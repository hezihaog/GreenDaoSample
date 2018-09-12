package com.hzh.green.dao.sample;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.hzh.green.dao.sample.db.aggr.AggrPersonController;
import com.hzh.green.dao.sample.enums.CertificateTypeEnums;
import com.hzh.green.dao.sample.enums.SexEnums;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;
import com.hzh.green.dao.sample.model.vo.PersonInfoListVO;
import com.hzh.green.dao.sample.util.RecyclerViewHelper;
import com.hzh.green.dao.sample.viewbinder.PersonViewBinderViewBinder;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends RxAppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private RecyclerViewHelper mRecyclerViewHelper;
    private boolean isEnsureCheckData = false;
    private AggrPersonController mPersonController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        MultiTypeAdapter adapter = new MultiTypeAdapter();
        adapter.register(PersonInfoListVO.class, new PersonViewBinderViewBinder());
        recyclerView.setAdapter(adapter);
        //加载更多加载监听
        mRecyclerViewHelper = RecyclerViewHelper.create(swipeRefreshLayout, recyclerView, adapter, new RecyclerViewHelper.OnLoadListener() {
            @Override
            public void onSwipeRefresh(int page, boolean isFirst) {
                loadData(page, true);
            }

            @Override
            public void onLoadMore(int page, boolean isFirst) {
                loadData(page, false);
            }
        });
        //初始化默认数据
        mPersonController = new AggrPersonController();
        mRecyclerViewHelper.startRefreshWithLoading();
    }

    private void loadData(final int page, final boolean isRefresh) {
        //默认每页的条数
        final int pageSize = 20;
        Disposable disposable = Observable.create(new ObservableOnSubscribe<List<PersonInfoListVO>>() {
            @Override
            public void subscribe(ObservableEmitter<List<PersonInfoListVO>> emitter) throws Exception {
                if (!isEnsureCheckData) {
                    boolean hasData = mPersonController.hasData();
                    if (!hasData) {
                        int size = 100;
                        Log.d(TAG, ("本次插入" + size + "条数据 " + "插入开始..."));
                        long start = System.currentTimeMillis();
                        for (int i = 0; i < size; i++) {
                            PersonInfoDTO dto = new PersonInfoDTO();
                            dto.setPersonName("王小二" + i);
                            dto.setSex(SexEnums.male.getCode());
                            dto.setAge(18);
                            //设置住户手机号
                            dto.setMobiles(new String[]{"13812397891", "13027883271"});
                            //设置住户身份证
                            dto.setCertificateNo("440111199308126612");
                            dto.setCertificateType(CertificateTypeEnums.IDENTITY.getCode());
                            mPersonController.addPersonInfo(dto);
                        }
                        long end = System.currentTimeMillis();
                        Log.d(TAG, ("本次插入" + size + "条数据 " + "插入结束...耗时：" + (end - start)));
                    }
                    isEnsureCheckData = true;
                }
                Log.d(TAG, ("查询开始..."));
                long start = System.currentTimeMillis();
                List<PersonInfoListVO> allPersonList = mPersonController.getAllPersonPageList(page, pageSize).getRecords();
                long end = System.currentTimeMillis();
                Log.d(TAG, ("查询结束...耗时：" + (end - start)));
                emitter.onNext(allPersonList);
                emitter.onComplete();
            }
        })
                //绑定生命周期进行切断
                .compose(this.<List<PersonInfoListVO>>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PersonInfoListVO>>() {
                    @Override
                    public void accept(List<PersonInfoListVO> personInfoVOList) throws Exception {
                        boolean hasNext = true;
                        if (personInfoVOList.size() < pageSize) {
                            hasNext = false;
                        }
                        mRecyclerViewHelper.updateDataSource(isRefresh, personInfoVOList, hasNext);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this.getApplicationContext(), "哎呀，出错啦...", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "异常：" + throwable.getMessage());
                    }
                });
    }
}
package com.hzh.green.dao.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hzh.green.dao.sample.adater.MMCRecyclerViewAdapter;
import com.hzh.green.dao.sample.db.UserDao;
import com.hzh.green.dao.sample.entity.User;
import com.hzh.green.dao.sample.util.GreenDaoManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.add)
    Button add;
    @Bind(R.id.delete)
    Button delete;
    @Bind(R.id.query)
    Button query;
    @Bind(R.id.update)
    Button update;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private UserDao mUserDao;
    private MMCRecyclerViewAdapter adapter;
    private List<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mUserDao = GreenDaoManager.getInstance().getDaoSession().getUserDao();
        adapter = new MMCRecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerView.setAdapter(adapter);
        userList.addAll(mUserDao.loadAll());
        adapter.setDataAndNotify(userList);
    }

    @OnClick({R.id.add, R.id.delete, R.id.query, R.id.update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                add("Wally", 18, "i am wally");
                break;
            case R.id.delete:
                delete("Wally");
                break;
            case R.id.query:
                query("Wally");
                break;
            case R.id.update:
                update("Wally", "hello green dao");
                break;
            default:
                break;
        }
        adapter.setDataAndNotify(mUserDao.loadAll());
    }

    private void add(String userName, int age, String sign) {
        //构建userId，为当前最后一个用户的id加1
        List<User> allUserList = mUserDao.loadAll();
        String userId = null;
        if (allUserList.size() > 0) {
            User lastUser = allUserList.get(allUserList.size() - 1);
            userId = String.valueOf(Long.valueOf(lastUser.getUserId()) + 1);
        } else {
            userId = "0";
        }
        User user = new User(null, userId, userName, age, sign);
        long insertId = mUserDao.insert(user);
        if (insertId != -1) {
            toast("新增一条用户信息 ::: " + userName);
        } else {
            toast("新增用户异常 ::: id为" + userId + " userName为 ::: " + userName);
        }
    }

    private void delete(String userName) {
        List<User> list = mUserDao.queryBuilder().where(UserDao.Properties.UserName.eq(userName)).list();
        if (list != null && list.size() > 0) {
            mUserDao.delete(list.get(0));
            toast("删除用户名为 ::: " + userName + " 的用户");
        } else {
            toast("删除用户失败 ::: 没有找到用户名为 ::: " + userName + "的用户");
        }
    }

    private void query(String userName) {
        List<User> list = mUserDao.queryBuilder().where(UserDao.Properties.UserName.eq(userName)).list();
        if (list != null && list.size() > 0) {
            User user = list.get(0);
            if (user != null) {
                toast("查询到用户 --> " + userName + " ::: " + user.getUserName());
            }
        } else {
            toast("查询不到用户名为 ::: " + userName + "的用户");
        }
    }

    private void update(String userName, String newSign) {
        List<User> list = mUserDao.queryBuilder().where(UserDao.Properties.UserName.eq(userName)).list();
        if (list != null && list.size() > 0) {
            User user = list.get(0);
            user.setSign(newSign);
            mUserDao.update(user);
            toast("更新成功 ::: 用户名为 ::: " + userName + "的用户的 sign 更新为 ::: " + user.getSign());
        } else {
            toast("更新失败，查到不到用户名为 ::: " + userName + "的用户");
        }
    }

    private void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

package com.hzh.green.dao.sample.viewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hzh.green.dao.sample.R;
import com.hzh.green.dao.sample.model.vo.PersonInfoListVO;

import me.drakeet.multitype.ItemViewBinder;


/**
 * Package: com.github.wally.wcdbsample.viewbinder
 * FileName: PersonViewBinderViewBinder
 * Date: on 2018/8/4  下午9:52
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class PersonViewBinderViewBinder extends ItemViewBinder<PersonInfoListVO, PersonViewBinderViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_person_view_binder, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PersonInfoListVO personInfoListVO) {
        holder.mNameTv.setText(personInfoListVO.getPersonName());
        holder.mAgeTv.setText(String.valueOf(personInfoListVO.getAge()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNameTv;
        private final TextView mAgeTv;

        ViewHolder(View itemView) {
            super(itemView);
            mNameTv = itemView.findViewById(R.id.name_tv);
            mAgeTv = itemView.findViewById(R.id.age_tv);
        }
    }
}

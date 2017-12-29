package com.hzh.green.dao.sample.adater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hzh.green.dao.sample.R;
import com.hzh.green.dao.sample.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.hzh.green.dao.sample.adater
 * FileName: MMCRecyclerViewAdapter
 * Date: on 2017/12/28  下午6:01
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class MMCRecyclerViewAdapter extends RecyclerView.Adapter<MMCRecyclerViewAdapter.MMCViewHolder> {
    private List<User> userList = new ArrayList<User>();

    @Override
    public MMCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MMCViewHolder(LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.item_user_info, parent, false));
    }

    @Override
    public void onBindViewHolder(MMCViewHolder holder, int position) {
        if (userList.size() > 0) {
            User user = userList.get(position);
            holder.userNameTv.setText(user.getUserName());
            holder.ageTv.setText(String.valueOf(user.getAge()));
            holder.signTv.setText(user.getSign());
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addDataAndNotify(List<User> userList) {
        if (userList == null) {
            return;
        }
        this.userList.addAll(userList);
        notifyDataSetChanged();
    }

    public void setDataAndNotify(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    public static class MMCViewHolder extends RecyclerView.ViewHolder {
        private final TextView userNameTv;
        private final TextView ageTv;
        private final TextView signTv;

        public MMCViewHolder(View itemView) {
            super(itemView);
            userNameTv = itemView.findViewById(R.id.userNameTv);
            ageTv = itemView.findViewById(R.id.ageTv);
            signTv = itemView.findViewById(R.id.signTv);
        }
    }
}
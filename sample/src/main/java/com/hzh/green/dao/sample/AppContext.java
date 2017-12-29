package com.hzh.green.dao.sample;

import android.app.Application;

import com.hzh.green.dao.sample.util.GreenDaoManager;

/**
 * Package: com.hzh.green.dao.sample
 * FileName: AppContext
 * Date: on 2017/12/28  下午5:07
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class AppContext extends Application {
    private static AppContext mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        GreenDaoManager.init();
    }

    public static AppContext getInstance() {
        return mInstance;
    }
}
package com.hzh.green.dao.sample.util;

import android.database.sqlite.SQLiteDatabase;

import com.hzh.green.dao.sample.AppContext;
import com.hzh.green.dao.sample.model.entity.DaoMaster;
import com.hzh.green.dao.sample.model.entity.DaoSession;

/**
 * Package: com.hzh.green.dao.sample.util
 * FileName: GreenDaoManager
 * Date: on 2017/12/28  下午5:01
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class GreenDaoManager {
    private static final String DB_NAME = "mmc_dao";
    private static volatile GreenDaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private GreenDaoManager() {
        if (mInstance == null) {
            SampleSQLiteOpenHelper openHelper = new SampleSQLiteOpenHelper(AppContext.getInstance(), DB_NAME);
            SQLiteDatabase db = openHelper.getWritableDatabase();
            mDaoMaster = new DaoMaster(db);
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static void init() {
        getInstance();
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
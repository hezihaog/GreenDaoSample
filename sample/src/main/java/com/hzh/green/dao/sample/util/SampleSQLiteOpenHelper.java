package com.hzh.green.dao.sample.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.hzh.green.dao.sample.model.entity.CertificateInfoEntityDao;
import com.hzh.green.dao.sample.model.entity.DaoMaster;
import com.hzh.green.dao.sample.model.entity.PersonInfoEntityDao;
import com.hzh.green.dao.sample.model.entity.PersonMobileEntityDao;

import org.greenrobot.greendao.database.Database;

/**
 * Package: com.hzh.green.dao.sample.util
 * FileName: MySQLiteOpenHelper
 * Date: on 2017/12/28  下午4:54
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

public class SampleSQLiteOpenHelper extends DaoMaster.OpenHelper {
    private static final String TAG = SampleSQLiteOpenHelper.class.getSimpleName();

    public SampleSQLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public SampleSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        if (oldVersion == newVersion) {
            Log.i(TAG, "数据库无需升级");
            return;
        }
        Log.i(TAG, "数据库从" + oldVersion + "升级到 ::: " + newVersion + "版本");
        //使用GreenDaoUpgradeHelper辅助类进行升级
        MigrationHelper.migrate(db, PersonInfoEntityDao.class,
                PersonMobileEntityDao.class,
                CertificateInfoEntityDao.class);
    }
}
package com.example.dell.h1810a_5_29_2.dbutils;

import com.example.dell.h1810a_5_29_2.bean.Bean;
import com.example.dell.h1810a_5_29_2.dao.BeanDao;
import com.example.dell.h1810a_5_29_2.dao.DaoMaster;
import com.example.dell.h1810a_5_29_2.dao.DaoSession;
import com.example.dell.h1810a_5_29_2.myapp.MyApp;

import java.util.ArrayList;
import java.util.List;

public class DbUtils {


    private static DbUtils dbUtils;
    private final BeanDao mBeanDao;

    public DbUtils() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "qimofuxi" + ".db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mBeanDao = daoSession.getBeanDao();
    }

    private static DbUtils getDbUtils() {
        if (dbUtils == null) {
            synchronized (DbUtils.class) {
                if (dbUtils == null) {
                    dbUtils = new DbUtils();
                }
            }
        }
        return dbUtils;
    }

    public void insert(ArrayList<Bean> bean) {
        if (has()) {
            mBeanDao.insertOrReplaceInTx(bean);
        }
    }

    public void delete(Bean bean) {
        mBeanDao.delete(bean);
    }

    public List<Bean> query() {
        return mBeanDao.queryBuilder().list();
    }

    private boolean has() {
        List<Bean> list = mBeanDao.queryBuilder().list();
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}

package com.example.shayanmoradi.arioclub.database;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

public class App extends Application {
    private static App app;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        MyDevOpenHelper myDevOpenHelper = new MyDevOpenHelper(this, "DatabaseName");
        Database db = myDevOpenHelper.getWritableDb();

        daoSession = new DaoMaster(db).newSession();

        app = this;
    }

    public static App getApp() {
        return app;
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }
}


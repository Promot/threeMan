package com.promote.threeman.application;

import android.app.Application;

import com.promote.threeman.dao.DbHelper;

/**
 * Created by ACER on 2015/3/25.
 */
public class ThreeMenApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DbHelper.init(getApplicationContext());
    }

}

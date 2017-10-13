package com.alex.waveview;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * 作者：Alex
 * 时间：2016年08月19日    22:23
 * 博客：http://www.jianshu.com/users/c3c4ea133871/subscriptions
 */

public class App extends Application {



    public static RefWatcher getRefWatcher(Context context) {
       App applicationContext = (App) context.getApplicationContext();
        return applicationContext.install;
    }
    private RefWatcher install;
    @Override
    public void onCreate() {
        super.onCreate();
        install = LeakCanary.install(this);
    }

}

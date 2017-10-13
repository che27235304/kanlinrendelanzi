package com.example.mvprxjava2degger2retrofit2.app;


import com.example.mvprxjava2degger2retrofit2.base.BaseActivity;
import com.example.mvprxjava2degger2retrofit2.base.BaseFragment;

/**
 * Created by chj on 2017/8/20.
 */

public class App extends  BaseApplication implements Thread.UncaughtExceptionHandler{

    public static BaseActivity mBaseActivity;
    public static BaseFragment lastfragment;


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
}

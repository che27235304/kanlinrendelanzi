package com.example.mvprxjava2degger2retrofit2.view;

import com.example.mvprxjava2degger2retrofit2.MainActivity;
import com.example.mvprxjava2degger2retrofit2.prenter.Yilaizhuru;

import dagger.Component;

/**
 * Created by KING on 2017/9/18 22:3
 * 邮箱:992767879@qq.com
 */
@Component(dependencies = Yilaizhuru.class )
public interface Qiaoliang {
    void inject(MainActivity activity);
}

package com.example.mvprxjava2degger2retrofit2.prenter;

import com.example.mvprxjava2degger2retrofit2.view.Iview;

import dagger.Module;
import dagger.Provides;

/**
 * Created by KING on 2017/9/18 22:32
 * 邮箱:992767879@qq.com
 */
@Module
public class Yilaizhuru {
    private Iview iview;
    public Yilaizhuru(Iview iview){
        this.iview=iview;
    }
    @Provides
    public Iview getaaa(){
        return iview;
    }
}

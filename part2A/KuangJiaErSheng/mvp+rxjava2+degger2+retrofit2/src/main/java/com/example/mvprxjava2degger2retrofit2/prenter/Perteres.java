package com.example.mvprxjava2degger2retrofit2.prenter;

import android.content.Context;
import android.util.Log;

import com.example.mvprxjava2degger2retrofit2.bean.ShiLei;
import com.example.mvprxjava2degger2retrofit2.mudel.Model;
import com.example.mvprxjava2degger2retrofit2.mudel.Shuju;
import com.example.mvprxjava2degger2retrofit2.view.Iview;

import javax.inject.Inject;

/**
 * Created by KING on 2017/9/18 22:34
 * 邮箱:992767879@qq.com
 */

public class Perteres implements Shuju {
    private Model model;
    private Iview iview;
    @Inject
    public Perteres(Iview iview){
        model=new Model(this);
        this.iview=iview;
        Log.e("TAG","333333333");
    }
    public void xianshi(Context context){
        model.qingqiu(context);
        Log.e("TAG","111111111");
    }

    @Override
    public void chuandi(ShiLei shiLei) {
        iview.shixian(shiLei);
        Log.e("TAG","2222222222");
    }
}

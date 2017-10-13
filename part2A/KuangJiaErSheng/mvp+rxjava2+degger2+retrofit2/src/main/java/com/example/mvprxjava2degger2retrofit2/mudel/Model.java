package com.example.mvprxjava2degger2retrofit2.mudel;

import android.content.Context;
import android.util.Log;

import com.example.mvprxjava2degger2retrofit2.bean.ShiLei;
import com.example.mvprxjava2degger2retrofit2.bean.Shujukulei;
import com.example.mvprxjava2degger2retrofit2.dom.ShujukuleiDao;
import com.example.mvprxjava2degger2retrofit2.mudel.http.HttpUtils;
import com.example.mvprxjava2degger2retrofit2.mudel.shujuku.Shujukus;

import java.util.List;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by KING on 2017/9/18 22:24
 * 邮箱:992767879@qq.com
 */
public class Model {
    private Shuju shuju;
    public Model(Shuju shuju){
        this.shuju=shuju;
        Log.e("TAG","6666666666");
    }
    public  void qingqiu(Context context){
        HttpUtils.createWeatherService(context).getqingqiu()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        Log.e("TAG","7777777777");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShiLei>() {
                    @Override
                    public void onCompleted() {
                        Log.e("TAG","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","Throwable");
                    }

                    @Override
                    public void onNext(ShiLei shiLei) {
                        shuju.chuandi(shiLei);
                        Log.e("TAG","55555555555");
                    }
                });
    }
    public void shujuku(Context context){
        //这里面实现查询数据
        ShujukuleiDao daor = Shujukus.geiIntence(context).getDaor();
        //这是所查询的数据5
        List<Shujukulei> list = daor.queryBuilder().list();
    }
}

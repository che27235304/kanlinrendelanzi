package com.example.mvprxjava2degger2retrofit2.mudel.http;

import com.example.mvprxjava2degger2retrofit2.bean.ShiLei;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by KING on 2017/9/18 22:12
 * 邮箱:992767879@qq.com
 */

public interface SeviserRec {
    @GET("kehuduan/PAGE14501749764071042/index.json")
    Observable<ShiLei> getqingqiu();
}

package com.example.lenovo.kuangjiaersheng;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by KING on 2017/9/18 08:57
 * 邮箱:992767879@qq.com
 */

public interface Ijielou{
    @GET("kehuduan/PAGE14501749764071042/index.json")
    Call<ShiLei> get();
}

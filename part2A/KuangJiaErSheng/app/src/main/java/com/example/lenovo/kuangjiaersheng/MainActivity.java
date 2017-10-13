package com.example.lenovo.kuangjiaersheng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String a="http://www.ipanda.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit build = builder.baseUrl(a)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //这里是create接口要记住
        Ijielou ijielou = build.create(Ijielou.class);
        Call<ShiLei> shiLeiCall = ijielou.get();
        shiLeiCall.enqueue(new Callback<ShiLei>() {
            @Override
            public void onResponse(Call<ShiLei> call, Response<ShiLei> response) {
                ShiLei body = response.body();
                ShiLei.DataBean.BigImgBean bigImgBean = body.getData().getBigImg().get(0);
                String title = bigImgBean.getTitle();
                Log.e("TAG",title);
            }

            @Override
            public void onFailure(Call<ShiLei> call, Throwable t) {

            }
        });

    }
}

package com.example.mvprxjava2degger2retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mvprxjava2degger2retrofit2.bean.ShiLei;
import com.example.mvprxjava2degger2retrofit2.prenter.Perteres;
import com.example.mvprxjava2degger2retrofit2.prenter.Yilaizhuru;
import com.example.mvprxjava2degger2retrofit2.view.DaggerQiaoliang;
import com.example.mvprxjava2degger2retrofit2.view.Iview;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements Iview {
    @Inject
    Perteres perteres;
    @Inject
    Javaaa javaaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerQiaoliang.builder().yilaizhuru(new Yilaizhuru(this)).build().inject(this);
        perteres.xianshi(this);
        javaaa.qq("天天");
    }
    @Override
    public void shixian(ShiLei shiLei) {
        Toast.makeText(this, shiLei.getData().getBigImg().get(1).getTitle(), Toast.LENGTH_SHORT).show();
        Log.e("TAG","444444444");
    }
}

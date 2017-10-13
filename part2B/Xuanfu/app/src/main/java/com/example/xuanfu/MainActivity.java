package com.example.xuanfu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start_id;
    private Button remove_id;
    private Button bt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Button start = (Button) findViewById(R.id.start_id);
        //获取移除按钮
        Button remove = (Button) findViewById(R.id.remove_id);
        //绑定监听
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, FxService.class);
                //启动FxService
                startService(intent);
                finish();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //uninstallApp("com.phicomm.hu");
                Intent intent = new Intent(MainActivity.this, FxService.class);
                //终止FxService
                stopService(intent);
                JCVideoPlayer.releaseAllVideos();
            }
        });

    }

    private void initView() {
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt3:
                startActivity(new Intent(this, Main2Activity.class));
                break;
        }
    }
}

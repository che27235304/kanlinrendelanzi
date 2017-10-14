package com.jiyun.com.newglide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

public class Main2Activity extends AppCompatActivity {


    private GridView mgrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        MyAdapter adapter = new MyAdapter(this);
        mgrid.setAdapter(adapter);

    }

    private void initView() {

        mgrid = (GridView) findViewById(R.id.mgrid);

    }
}

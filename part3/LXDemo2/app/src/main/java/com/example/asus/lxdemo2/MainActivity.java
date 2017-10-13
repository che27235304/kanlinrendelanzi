package com.example.asus.lxdemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SlideListView listview;
    private List<String> dataList = new ArrayList<>();
    private SlideAdapter slideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        Listener();
    }

    private void Listener() {
        slideAdapter.ButtonClick(new SlideAdapter.setButtonClick() {
            @Override
            public void setbuttonclick(TextView itemTvToTop, TextView itemTvNoRead, TextView itemTvDelete, final int i) {
                itemTvToTop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s = dataList.get(i);
                        dataList.remove(i);
                        dataList.add(0,s);
                        slideAdapter.notifyDataSetChanged();
                    }
                });
                itemTvNoRead.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "22222222", Toast.LENGTH_SHORT).show();
                    }
                });
                itemTvDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dataList.remove(i);
                        slideAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 25; i++) {
            dataList.add("张三"+i);
        }
        slideAdapter = new SlideAdapter(MainActivity.this,dataList);
        listview.setAdapter(slideAdapter);
    }

    private void initView() {
        listview = (SlideListView) findViewById(R.id.listview);
    }
}

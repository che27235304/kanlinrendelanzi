package com.lzy.imagepicker.day17_search_editext;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.imagepicker.day17_search_editext.db.DbManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuwangping on 2017/8/6.
 */

public class EdietxtActivity extends Activity {
    TextView tvTip;
    private List<String> mList = new ArrayList<>();
    private List<String> list;
    private ListViewAdapter adapter;
    private DbManager manager;
    private EditText Search_Editext;
    private TextView Search_cancel;
    private TextView tv_tip;
    private ListView Search_ListView;
    private TextView Text_Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editext);
        initView();
        manager= new DbManager(EdietxtActivity.this);
        Search_Editext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {// 修改回车键功能
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    // 按完搜索键后将当前查询的关键字保存起来,如果该关键字已经存在就不执行保存
                   if(!Search_Editext.getText().toString().isEmpty()) {

                       boolean insert = manager.insert(Search_Editext.getText().toString());

                       mList=manager.getList();
                       // TODO 根据输入的内容模糊查询商品，并跳转到另一个界面，由你自己去实现
                       Toast.makeText(EdietxtActivity.this, "clicked!", Toast.LENGTH_SHORT).show();
                   }


                }
                return false;
            }
        });

        Search_Editext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Search_Editext.getText().toString().length()== 0) {
                    tvTip.setText("搜索历史");
                    initData();
                }
            }
        });
        Text_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.clear();
                manager.delete();
                adapter.notifyDataSetChanged();
            }
        });
        initData();
    }

    private void initData() {
        mList=manager.getList();
        adapter = new ListViewAdapter(EdietxtActivity.this,mList);
        if (mList != null) {
            Search_ListView.setAdapter(adapter);
            Text_Clear.setVisibility(View.VISIBLE);
        } else {
            Text_Clear.setVisibility(View.GONE);
        }
    }

    private void initView() {
        Search_Editext = (EditText) findViewById(R.id.Search_Editext);
        Search_cancel = (TextView) findViewById(R.id.Search_cancel);
        tv_tip = (TextView) findViewById(R.id.tv_tip);
        Search_ListView = (ListView) findViewById(R.id.Search_ListView);
        Text_Clear = (TextView) findViewById(R.id.Text_Clear);
    }

    private void submit() {
        // validate
        String Editext = Search_Editext.getText().toString().trim();
        if (TextUtils.isEmpty(Editext)) {
            Toast.makeText(this, "搜索博客，软件，资讯，问答", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

    }
}

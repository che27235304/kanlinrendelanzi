package com.lzy.imagepicker.day17_search_editext.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private MyHelper mHelper;
    private SQLiteDatabase mDb;
    private Context context;

    public DbManager(Context context) {
        this.context = context;
        mHelper = new MyHelper(context, "search.db", 1);
        mDb = mHelper.getWritableDatabase();
    }

    public boolean insert(String name) {
        boolean boo;
        ContentValues con = new ContentValues();
        con.put("name", name);
        long ins = mDb.insert("student", null, con);
        if (ins > 0) {
            boo = true;
        } else {
            boo = false;
        }
        return boo;
    }

    public void delete() {
        mDb.delete("student", null, null);
    }

    public List<String> getList() {
        List<String> mList = new ArrayList<>();
        Cursor cursor = mDb.query("student", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String ss = cursor.getString(cursor.getColumnIndex("name"));
            mList.add(ss);
        }
        return mList;
    }
}

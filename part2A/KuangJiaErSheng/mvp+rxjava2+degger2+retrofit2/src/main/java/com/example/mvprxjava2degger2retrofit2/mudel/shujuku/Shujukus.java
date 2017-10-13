package com.example.mvprxjava2degger2retrofit2.mudel.shujuku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mvprxjava2degger2retrofit2.dom.DaoMaster;
import com.example.mvprxjava2degger2retrofit2.dom.DaoSession;
import com.example.mvprxjava2degger2retrofit2.dom.ShujukuleiDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by KING on 2017/9/21 16:56
 * 邮箱:992767879@qq.com
 */

public class Shujukus {
    private static Shujukus shujukus;
    private final DaoMaster.OpenHelper devOpenHelper;

    private Shujukus(Context context){
        devOpenHelper = new DaoMaster.DevOpenHelper(context,"shujuku.db");
    }
    public static Shujukus geiIntence(Context context){
        if(shujukus==null){
            synchronized (Shujukus.class){
                if(shujukus==null){
                    shujukus=new Shujukus(context);
                }
            }
        }
        return shujukus;
    }
//    public SQLiteDatabase reader(){
//            SQLiteDatabase readableDatabase = devOpenHelper.getReadableDatabase();
//            return readableDatabase;
//        }
//        public SQLiteDatabase writer(){
//            return devOpenHelper.getWritableDatabase();
//        }
        public ShujukuleiDao getDaor(){
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDatabase());
            DaoSession daoSession = daoMaster.newSession();
            ShujukuleiDao studentDao = daoSession.getShujukuleiDao();
            return studentDao;
        }
        public ShujukuleiDao getDaow(){
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            DaoSession daoSession = daoMaster.newSession();
            ShujukuleiDao studentDao = daoSession.getShujukuleiDao();
            return studentDao;
        }
}

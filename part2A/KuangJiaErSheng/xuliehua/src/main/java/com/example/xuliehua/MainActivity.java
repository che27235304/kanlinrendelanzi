package com.example.xuliehua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //序列化
        xuliehua();
        fanxuliehua();

    }

    private void fanxuliehua() {
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("xuliehua.txt"));
            User newUser = (User) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void xuliehua(){
        User user = new User(0,"jake",true);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("xuliehua.txt"));
            out.writeObject(user);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

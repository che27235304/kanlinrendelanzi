package com.example.administrator.walk2.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.walk2.MyService;

/**
 * Created by Administrator on 2017/10/12.
 */

public class BootBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "BootBroadcastReceiver";

    private static final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("TAG", "Boot this system , BootBroadcastReceiver onReceive()");
        Toast.makeText(context, "开机了！", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(context, MyService.class);
        context.startService(intent1);
        if (intent.getAction().equals(ACTION_BOOT)) {
            Log.i("TAG", "BootBroadcastReceiver onReceive(), Do thing!");
            Toast.makeText(context, "开机了！！", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(context, MyService.class);
            context.startService(intent2);
        }
    }
}
package com.example.administrator.walk2.broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/10/12.
 */

public class ShutdownBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "ShutdownBroadcastReceiver";

    private static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("TAG", "Shut down this system, ShutdownBroadcastReceiver onReceive()");
        Toast.makeText(context, "关机了！", Toast.LENGTH_SHORT).show();

        if (intent.getAction().equals(ACTION_SHUTDOWN)) {
            Log.i("TAG", "ShutdownBroadcastReceiver onReceive(), Do thing!");
            Toast.makeText(context, "关机了！！", Toast.LENGTH_SHORT).show();

        }
    }
}
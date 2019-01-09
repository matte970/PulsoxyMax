package com.example.mvasc.pulsoxymax;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastR extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Toast.makeText(context, "Broadcast Intent Detected.",
                Toast.LENGTH_LONG).show();
    }
}
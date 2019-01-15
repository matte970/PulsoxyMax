package com.example.mvasc.pulsoxymax;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.randomgenerator.OxyValues;

public class LimitBroadcastReceiver extends BroadcastReceiver {

    private OxyChangeListener oxyChangeListener;

    public LimitBroadcastReceiver(OxyChangeListener oxyChangeListener) {
        this.oxyChangeListener = oxyChangeListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        OxyValues oxyValue = intent.getParcelableExtra("Ox");
        this.oxyChangeListener.onChange(oxyValue.getValue(), oxyValue.getTime());

    }
}
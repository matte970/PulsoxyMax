package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

public class home extends AppCompatActivity implements OxyChangeListener {

    private Switch simpleSwitch;
    private DatabaseHelper databaseHelper;
    private IntentFilter filter;
    private LimitBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.simpleSwitch = findViewById(R.id.recordingSwitch);
        this.databaseHelper = new DatabaseHelper(this);

        this.filter = new IntentFilter("PulsOXyMax");
        this.receiver = new LimitBroadcastReceiver(this);
    }

    public void go_to_options(android.view.View next) {
        Intent i = new Intent(this, set_up.class);
        startActivity(i);
    }

    public void go_to_start(android.view.View next) {
        Intent i = new Intent(this, start.class);
        startActivity(i);
    }


    public void go_to_liveView(android.view.View next) {
        Intent i = new Intent(this, live_values.class);
        startActivity(i);
    }

    public void recordingSwitchChange(View view) {
        if (this.simpleSwitch.isChecked()) {
            registerReceiver(receiver, filter);
        } else {
            unregisterReceiver(receiver);
        }
    }

    @Override
    public void onChange(int oxy, long time) {
        this.databaseHelper.insertRecord(new OxyValue(oxy, time));
    }
}

package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class live_values extends AppCompatActivity implements OxyChangeListener {

    DatabaseHelper databaseHelper;

    private TextView liveOxy;
    private IntentFilter filter;
    private LimitBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_values);

        this.databaseHelper = new DatabaseHelper(this);

        this.liveOxy = findViewById(R.id.liveOxy);

        this.filter = new IntentFilter("PulsOXyMax");
        this.receiver = new LimitBroadcastReceiver(this);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, filter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        unregisterReceiver(receiver);
    }

    public void addDummyRecord(android.view.View next) {
        OxyValue dummy = new OxyValue(1000, System.currentTimeMillis());
        this.databaseHelper.insertRecord(dummy);
    }

    public void printStats(android.view.View next) {
        OxyStats stats = this.databaseHelper.getStatsOfDayAndHour(8, 0, 2019, 18);
    }

    public void clickOK(android.view.View next) {
        unregisterReceiver(receiver);
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }
    public void go_to_home(android.view.View next) {
        Intent i = new Intent(this, home.class);
        startActivity(i);

    }

    @Override
    public void onChange(int oxy, long time) {

        liveOxy.setText("" + oxy);

        if (oxy<90){
            MediaPlayer mp=MediaPlayer.create(this,R.raw.reception);
            mp.start();
        }
    }
}

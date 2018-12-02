package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void start_sleep_mode(android.view.View next){

    }

    public void go_to_stats(android.view.View next){
        Intent i = new Intent(this, stats.class);
        startActivity(i);
    }

    public void go_to_options(android.view.View next){
        Intent i = new Intent(this, set_up.class);
        startActivity(i);
    }

    public void go_to_start(android.view.View next){
        Intent i = new Intent(this, start.class);
        startActivity(i);
    }


    public void go_to_liveView(android.view.View next){
        Intent i = new Intent(this, live_values.class);
        startActivity(i);
    }
}

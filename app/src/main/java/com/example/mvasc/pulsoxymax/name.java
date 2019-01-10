package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }
    public void go_to_set_up(android.view.View next) {
        Intent i = new Intent(this, set_up.class);
        startActivity(i);

    }

    public void go_to_home(android.view.View next) {
        Intent i = new Intent(this, home.class);
        startActivity(i);
//i=0;
    }
}

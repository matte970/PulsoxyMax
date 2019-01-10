package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void go_to_home(android.view.View next){
        Intent i = new Intent(this, e_mail.class);
        startActivity(i);
    }

    public void go_to_setUp(android.view.View next){
        Intent i = new Intent(this, set_up.class);
        startActivity(i);
    }
}


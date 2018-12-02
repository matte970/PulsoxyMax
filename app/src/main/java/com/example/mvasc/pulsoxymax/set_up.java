package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class set_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
    }

    public void go_to_start(android.view.View next){
        Intent i = new Intent(this, start.class);
        startActivity(i);
    }

    public void go_to_home(android.view.View next){
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }

    public void go_to_tones(android.view.View next){
        Intent i = new Intent(this, tones.class);
        startActivity(i);
    }

    public void go_to_limits(android.view.View next){
        Intent i = new Intent(this, limit.class);
        startActivity(i);
    }

    public void go_to_e_mail(android.view.View next){
        Intent i = new Intent(this, e_mail.class);
        startActivity(i);
    }
}

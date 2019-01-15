package com.example.mvasc.pulsoxymax;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        TextView textView =(TextView) findViewById(R.id.textView2);

        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String username = sharedPref.getString("username", "");
        textView.setText("Welcome back \n"+username);

    }
    public void go_to_home(android.view.View next){
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }

    public void go_to_setUp(android.view.View next){
        Intent i = new Intent(this, set_up.class);
        startActivity(i);
    }
}


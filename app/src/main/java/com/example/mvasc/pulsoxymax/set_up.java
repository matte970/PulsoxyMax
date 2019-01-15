package com.example.mvasc.pulsoxymax;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class set_up extends AppCompatActivity {
    TextView user_e_mail;
    TextView user_phone;
    TextView user_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        user_e_mail =(TextView) findViewById(R.id.button2);
        user_phone= (TextView) findViewById(R.id.button3);
        user_name= (TextView) findViewById(R.id.button);

    }

    public void go_to_home(android.view.View next) {
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }

    public void go_to_tones(android.view.View next) {
        Intent i = new Intent(this, tones.class);
        startActivity(i);
    }

    public void go_to_limits(android.view.View next) {
        Intent i = new Intent(this, limit.class);
        startActivity(i);
    }

    public void go_to_e_mail(android.view.View next) {
        Intent i = new Intent(this, e_mail.class);
        startActivity(i);
    }

    public void go_to_name(android.view.View next) {
        Intent i = new Intent(this, name.class);
        startActivity(i);
    }

    public void go_to_phone_no(android.view.View next) {
        Intent i = new Intent(this, phone_no.class);
        startActivity(i);
    }

    public void displayData(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String e_mail = sharedPref.getString("useremail", "");
        user_e_mail.setText(e_mail + "");

        SharedPreferences sharedPref2 = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String phone_no = sharedPref2.getString("userphone", " ");
        user_phone.setText(phone_no + "");

        SharedPreferences sharedPref1 = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String name = sharedPref1.getString("username", "");
        user_name.setText(name + "");
    }

}
package com.example.mvasc.pulsoxymax;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class name extends AppCompatActivity {

    EditText user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        user_name = (EditText) findViewById(R.id.editText_name);
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

    public void saveInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", user_name.getText().toString());
        editor.apply();
        editor.commit();
        Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, set_up.class);
        startActivity(i);
    }
}

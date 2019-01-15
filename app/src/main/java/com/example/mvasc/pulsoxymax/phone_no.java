package com.example.mvasc.pulsoxymax;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class phone_no extends AppCompatActivity {

    EditText user_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_no);
        user_phone = (EditText) findViewById(R.id.editText_phone_no);
    }

    public void saveInfo(View view){
        SharedPreferences sharedPref2 = getSharedPreferences ("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref2.edit();
        editor.putString("userphone", user_phone.getText().toString());
        editor.apply();

        Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, set_up.class);
        startActivity(i);
        displayData(user_phone);

    }
    public void go_to_set_up(android.view.View next) {
        Intent i = new Intent(this, set_up.class);
        startActivity(i);
        displayData(user_phone);


    }
    public void go_to_home(android.view.View next) {
        Intent i = new Intent(this, home.class);
        startActivity(i);

    }
    public void displayData(View view) {

        SharedPreferences sharedPref2 = getSharedPreferences ("userinfo", Context.MODE_PRIVATE);
        String phone_no = sharedPref2.getString("userphone", "");
        user_phone.setText(phone_no + "");
    }
}

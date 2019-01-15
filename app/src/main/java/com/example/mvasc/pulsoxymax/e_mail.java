package com.example.mvasc.pulsoxymax;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class e_mail extends AppCompatActivity {

    EditText user_e_mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_mail);
        user_e_mail = (EditText) findViewById(R.id.editText_e_mail);
    }

    //safe the user info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences ("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("useremail", user_e_mail.getText().toString());
        editor.apply();
        editor.commit();
        Toast.makeText(this, "saved", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, set_up.class);
        startActivity(i);
        displayData(user_e_mail);
    }

   public void displayData (View view) {

      SharedPreferences sharedPref = getSharedPreferences ("userinfo", Context.MODE_PRIVATE);
       String e_mail = sharedPref.getString("e-mail", "");
       user_e_mail.setText(e_mail + "");
   }

    public void go_to_set_up(android.view.View next) {
        Intent i = new Intent(this, set_up.class);
        startActivity(i);
        displayData(user_e_mail);

    }
    public void go_to_home(android.view.View next) {
        Intent i = new Intent(this, home.class);
        startActivity(i);


    }
}
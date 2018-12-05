package com.example.mvasc.pulsoxymax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.content.Intent;

public class e_mail extends AppCompatActivity {

    Button button;              //create new object
    AutoCompleteTextView acText;
    String[] hours = {"24 Hours", "48 Hours", "7 Days", "1 Month"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_mail);
        button = (Button) findViewById(R.id.button1);
        acText = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, hours);
        acText.setThreshold(1);
        acText.setAdapter(adapter);
    }

    public void go_to_options(android.view.View next) {
        Intent i = new Intent(this, stats.class);
        startActivity(i);

    }
}

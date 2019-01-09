package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class limit extends AppCompatActivity {

    int Limit;
    TextView LimitTextView = (TextView) findViewById(R.id.textView6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit);
        Limit=90;
        LimitTextView.setText(Limit);

        final Button buttonMinus = findViewById(R.id.button11);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Limit < 100) {
                    Limit++;
                    LimitTextView.setText(Limit);
                }
            }
        });

        final Button buttonPlus = findViewById(R.id.button12);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Limit > 0) {
                    Limit--;
                    LimitTextView.setText(Limit);
                }
            }
        });
    }

}

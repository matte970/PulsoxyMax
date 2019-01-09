package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class limit extends AppCompatActivity {

    int limitValue;
    TextView limitTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit);

        this.limitTextView = findViewById(R.id.limitTextView);
        this.limitValue = Integer.parseInt(this.limitTextView.getText().toString());
    }

    public void go_to_home(android.view.View next) {
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }

    public void increaseLimit(android.view.View view) {
        this.limitValue++;
        this.limitTextView.setText("" + limitValue);
    }

    public void decreaseLimit(android.view.View view) {
        this.limitValue--;
        this.limitTextView.setText("" + limitValue);
    }

}

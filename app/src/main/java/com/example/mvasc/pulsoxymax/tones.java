package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class tones extends AppCompatActivity {
    Button Button1;
    Button Button2;
    Button Button3;
    Button Button4;
    Button Button5;
    Button Button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tones);
        this.Button1 = findViewById(R.id.button1);
        this.Button2 = findViewById(R.id.button2);
        this.Button3 = findViewById(R.id.button3);
        this.Button4 = findViewById(R.id.button4);
        this.Button5 = findViewById(R.id.button5);
        this.Button6 = findViewById(R.id.button6);
    }

    public void go_to_home(android.view.View next){
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }
    public void go_to_set_up(android.view.View next) {
        Intent i = new Intent(this, set_up.class);
        startActivity(i);
    }

    public void chooseTone1(android.view.View view) {
        allButtonsGreen();
        Button1.setBackgroundColor(Color.YELLOW);
    }
    public void chooseTone2(android.view.View view) {
        allButtonsGreen();
        Button2.setBackgroundColor(Color.YELLOW);
    }
    public void chooseTone3(android.view.View view) {
        allButtonsGreen();
        Button3.setBackgroundColor(Color.YELLOW);
    }
    public void chooseTone4(android.view.View view) {
        allButtonsGreen();
        Button4.setBackgroundColor(Color.YELLOW);
    }
    public void chooseTone5(android.view.View view) {
        allButtonsGreen();
        Button5.setBackgroundColor(Color.YELLOW);
    }
    public void chooseTone6(android.view.View view) {
        allButtonsGreen();
        Button6.setBackgroundColor(Color.YELLOW);
    }

    public void allButtonsGreen(){
        Button1.setBackgroundColor(Integer.parseInt("#2CE70F"));
        Button2.setBackgroundColor(Integer.parseInt("#2CE70F"));
        Button3.setBackgroundColor(Integer.parseInt("#2CE70F"));
        Button4.setBackgroundColor(Integer.parseInt("#2CE70F"));
        Button5.setBackgroundColor(Integer.parseInt("#2CE70F"));
        Button6.setBackgroundColor(Integer.parseInt("#2CE70F"));
    }

}

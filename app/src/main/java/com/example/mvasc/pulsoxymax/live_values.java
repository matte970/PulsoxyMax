package com.example.mvasc.pulsoxymax;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class live_values extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_values);

        System.out.println("livevalues");

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.DB_NAME, new String[]{"oxy", "time"}, null, null, null, null, null);


        if (cursor.moveToFirst()) {
            Long oxy = cursor.getLong(0);
            Long time = cursor.getLong(1);
            System.out.println("juhu " + oxy);
            System.out.println("bbb " + time);
            while (cursor.moveToNext()) {
                oxy = cursor.getLong(0);
                time = cursor.getLong(1);
                System.out.println("juhu " + oxy);
                System.out.println("bbb " + time);
            }

        } else {
            System.out.println("oh nein");
        }
    }
}

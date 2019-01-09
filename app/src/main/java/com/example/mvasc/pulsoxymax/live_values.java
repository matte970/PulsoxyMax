package com.example.mvasc.pulsoxymax;

import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class live_values extends AppCompatActivity implements OxyChangeListener {

    DatabaseHelper databaseHelper;

    private TextView liveOxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_values);

        this.databaseHelper = new DatabaseHelper(this);

        this.liveOxy = findViewById(R.id.liveOxy);

        IntentFilter filter = new IntentFilter("PulsOXyMax");
        LimitBroadcastReceiver receiver = new LimitBroadcastReceiver(this);
        registerReceiver(receiver, filter);
    }

    public void addDummyRecord(android.view.View next) {
        OxyValue dummy = new OxyValue(1000, System.currentTimeMillis());
        this.databaseHelper.insertRecord(dummy);
    }

    public void printAllRecords(android.view.View next) {
        SQLiteDatabase db = this.databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, new String[]{"oxy", "time"}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            OxyValue oxy = getOxyValue(cursor);
            System.out.println(oxy);
            while (cursor.moveToNext()) {
                oxy = getOxyValue(cursor);
                System.out.println(oxy);
            }
        } else {
            // no records in database
        }

        printAverageOxy();
    }

    public void printAverageOxy() {
        SQLiteDatabase db = this.databaseHelper.getReadableDatabase();

        String query = "SELECT AVG(oxy), MIN(oxy), MAX(oxy) FROM " + DatabaseHelper.TABLE_NAME + ";";

        String criticalValuesQuery = "SELECT COUNT(oxy), MIN(oxy) FROM " + DatabaseHelper.TABLE_NAME + " WHERE oxy < 90;";

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            double average = cursor.getDouble(0);
            int min = cursor.getInt(1);
            int max = cursor.getInt(2);
            System.out.println("average: " + average);
            System.out.println("min: " + min);
            System.out.println("max: " + max);
            while (cursor.moveToNext()) {
                average = cursor.getDouble(0);
                min = cursor.getInt(1);
                max = cursor.getInt(2);
                System.out.println("average: " + average);
                System.out.println("min: " + min);
                System.out.println("max: " + max);

            }
        } else {
            // no records in database
        }

        Cursor criticalCursor = db.rawQuery(criticalValuesQuery, null);
        if (criticalCursor.moveToFirst()) {
            int count = criticalCursor.getInt(0);
            int min = criticalCursor.getInt(1);

            System.out.println("critical count: " + count);
            System.out.println("critical min: " + min);
            while (criticalCursor.moveToNext()) {
                count = criticalCursor.getInt(0);
                min = criticalCursor.getInt(1);

                System.out.println("critical count: " + count);
                System.out.println("critical min: " + min);

            }
        } else {
            // no records in database
        }

        // TODO call cursor.close() ??? for both ?
        cursor.close();
    }

    private OxyValue getOxyValue(Cursor cursor) {
        Integer oxy = cursor.getInt(0);
        Long time = cursor.getLong(1);
        return new OxyValue(oxy, time);
    }

    public void clickOK(android.view.View next) {
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }

    @Override
    public void onChange(int oxy, long time) {
        liveOxy.setText("" + oxy);
    }
}

package com.example.mvasc.pulsoxymax;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class live_values extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_values);

        this.databaseHelper = new DatabaseHelper(this);
    }

    public void addDummyRecord(android.view.View next) {
        OxyValue dummy = new OxyValue(1000, System.currentTimeMillis());
        this.databaseHelper.insertRecord(dummy);
    }

    public void printAllRecords(android.view.View next) {
        SQLiteDatabase db = this.databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.DB_NAME, new String[]{"oxy", "time"}, null, null, null, null, null);

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
    }

    private OxyValue getOxyValue(Cursor cursor) {
        Integer oxy = cursor.getInt(0);
        Long time = cursor.getLong(1);
        return new OxyValue(oxy, time);
    }
}

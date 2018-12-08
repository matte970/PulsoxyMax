package com.example.mvasc.pulsoxymax;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "pulsoxymax";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pulsoxy (\n" +
                "\t_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\tpuls INTEGER NOT NULL,\n" +
                "\toxy INTEGER NOT NULL,\n" +
                "\ttime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL \n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

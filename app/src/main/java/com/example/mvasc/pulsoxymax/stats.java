package com.example.mvasc.pulsoxymax;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class stats extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
    }
    public void go_to_home(android.view.View next) {
        Intent i = new Intent(this, home.class);
        startActivity(i);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment.DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    // Global Variables
    public static int mhour;
    public static int mminute;
    public static int myear;
    public static int mmonth;
    public static int mday;

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            mhour=hourOfDay;
            mminute=minute;

        }



        public static class DatePickerFragment extends DialogFragment
                implements DatePickerDialog.OnDateSetListener {

            @Override
            public Dialog onCreateDialog(Bundle savedInstanceState) {
                // Use the current date as the default date in the picker
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // Create a new instance of DatePickerDialog and return it
                return new DatePickerDialog(getActivity(), this, year, month, day);
            }

            public void onDateSet(DatePicker view, int year, int month, int day) {
                // Do something with the date chosen by the user
                myear=year;
                mmonth=month;
                mday=day;
            }
        }
    }

    public void searchDateStats (View view){

        DatabaseHelper mDbHelper = new DatabaseHelper(this);

       OxyStats stats = mDbHelper.getStatsOfDayAndHour(mday,mmonth,myear,mhour);

        TextView textView= (TextView) findViewById(R.id.textViewMax);

        textView.setText(stats.toString());






    }
}
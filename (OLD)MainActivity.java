package com.example.lee.myapplication;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity
{
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeCalendar();
    }

    public void initializeCalendar()
    {
        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setShowWeekNumber(false);
        calendar.setFirstDayOfWeek(1);
        calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.white));
        calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.clear));
        calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.clear));
        calendar.setSelectedDateVerticalBar(R.color.green);
        calendar.setOnDateChangeListener(new OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.example.lee.calendar;

import java.util.GregorianCalendar;
import android.app.Activity;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

public class Calendar extends Activity
{
    public GregorianCalendar calendar_month= new GregorianCalendar();
    public GregorianCalendar calendar_month_clone = new GregorianCalendar() ;
    private CalendarAdapter calendar_adapter;
    private TextView tv_month;
    private Intent currentIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        EventManager.init();

        tv_month = (TextView) findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MM yyyy", calendar_month));
        calendar_month = (GregorianCalendar) GregorianCalendar.getInstance();
        calendar_month_clone = (GregorianCalendar) calendar_month.clone();
        calendar_adapter = new CalendarAdapter(this, calendar_month,CalendarCollect.date_collection_arr);


        ImageButton previous = (ImageButton) findViewById(R.id.ib_prev);
        previous.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                setPreviousMonth();
                refreshCalendar();
            }
        });

        ImageButton next = (ImageButton) findViewById(R.id.Ib_next);
        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextMonth();
                refreshCalendar();
            }
        });

        GridView gridview = (GridView) findViewById(R.id.gv_calendar);
        gridview.setAdapter(calendar_adapter);
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((CalendarAdapter) parent.getAdapter()).setSelected(view, position);
                String selectedGridDate = CalendarAdapter.day_string.get(position);
                String[] separatedTime = selectedGridDate.split("-");
                String gridValueString = separatedTime[2].replaceFirst("^0*", "");
                int gridValue = Integer.parseInt(gridValueString);
                if ((gridValue > 10) && (position < 8)) {

                    setPreviousMonth();
                    refreshCalendar();
                } else if ((gridValue < 7) && (position > 28)) {

                    setNextMonth();
                    refreshCalendar();
                }
                ((CalendarAdapter) parent.getAdapter()).setSelected(view, position);
                ((CalendarAdapter) parent.getAdapter()).getPositionList(selectedGridDate, Calendar.this);
                Intent listViewIntent = new Intent(Calendar.this, ListViewActivity.class);
                listViewIntent.putExtra("DateSelect", selectedGridDate);
                startActivity(listViewIntent);


            }
        });
        Button weekViewBtn = (Button) findViewById(R.id.weekViewButton);
        weekViewBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weekViewActivityIntent = new Intent(Calendar.this, WeekViewActivity.class);
                startActivity(weekViewActivityIntent);
            }
        });

        //Testing
//        CalendarEvent event1 = new CalendarEvent("Hello World");
//        event1.setStart("11/11/2015");
//        CalendarEvent event2 = new CalendarEvent("Hello World again");
//        event2.setStart("11/11/2015");
//        CalendarEvent event3 = new CalendarEvent("Third event");
//        event3.setStart("11/13/2015");
//        CalendarEvent event4 = new CalendarEvent("Fourth event");
//        event4.setStart("11/16/2015");
//        CalendarEvent event5 = new CalendarEvent("Fifth event");
//        event5.setStart("11/18/2015");
//        EventManager.addEvent(event1);
//        EventManager.addEvent(event2);
//        EventManager.addEvent(event3);
//        EventManager.addEvent(event4);
//        EventManager.addEvent(event5);
    }
    protected void setPreviousMonth()
    {
        if (calendar_month.get(GregorianCalendar.MONTH) == calendar_month.getActualMinimum(GregorianCalendar.MONTH))
        {
            calendar_month.set((calendar_month.get(GregorianCalendar.YEAR) - 1), calendar_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        }
        else
        {
            calendar_month.set(GregorianCalendar.MONTH, calendar_month.get(GregorianCalendar.MONTH) - 1);
        }
    }
    protected void setNextMonth()
    {
        if (calendar_month.get(GregorianCalendar.MONTH) == calendar_month.getActualMaximum(GregorianCalendar.MONTH))
        {
            calendar_month.set((calendar_month.get(GregorianCalendar.YEAR) + 1), calendar_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        }
        else
        {
            calendar_month.set(GregorianCalendar.MONTH, calendar_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    public void refreshCalendar()
    {
        calendar_adapter.refreshDays();
        calendar_adapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MM yyyy", calendar_month));
    }
}


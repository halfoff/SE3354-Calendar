package com.example.lee.calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jack on 11/11/2015.
 */

public class AddEventActivity extends Activity implements OnClickListener {

    protected Button btn_Create;
    protected Button btn_Cancel;
    protected EditText txt_Title;
    protected TimePicker timePicker;

    private int indexOfAdd;
    private String eventTitle;
    private int eventTimeHR;
    private int eventTimeMIN;
    private String eventDate;
    private Bundle extra;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_layout);
        extra =getIntent().getExtras();
        getWidget();


    }

    public void getWidget()
    {
        btn_Create = (Button)   findViewById(R.id.btn_createEvent);
        btn_Cancel = (Button)   findViewById(R.id.btn_Cancel);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        txt_Title = (EditText)  findViewById(R.id.txt_editTitle);



    }

    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.btn_createEvent:
               eventTitle = txt_Title.getText().toString();
                eventDate = extra.getString("DateSelect");

                CalendarEvent tmpEvent= new CalendarEvent();
                eventTimeHR = timePicker.getCurrentHour();
                eventTimeMIN = timePicker.getCurrentMinute();


                EventManager.addEvent(tmpEvent);
                System.out.println("Event Added");

                //indexOfAdd=EventManager.addEvent(new CalendarEvent());
                //System.out.println("Event Added "+EventManager.getEvent(indexOfAdd).toString());
                this.finish();
                break;
            case R.id.btn_Cancel:
                System.out.println("Event cancled");
                this.finish();
                break;

            default:
                System.out.println("How did you default");
                break;
        }
    }
}

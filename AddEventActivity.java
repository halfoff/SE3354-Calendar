package com.example.lee.calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Activity for adding events.
 * Created by Jack on 11/11/2015.
 */

public class AddEventActivity extends Activity implements OnClickListener {

    protected Button btn_Create;
    protected Button btn_Cancel;
    protected EditText txt_Title;
    protected TimePicker startTimePicker;
    protected TimePicker endTimePicker;
    protected RadioGroup eventTypeGroup;
    protected RadioButton personalEvent, workEvent, holidayEvent, otherEvent;

    private int indexOfAdd;
    private String eventTitle;
    private int eventTimeHR;
    private int eventTimeMIN;
    private int endTimeHR;
    private int endTimeMIN;
    private String eventDate;
    private Bundle extra;
    private EventType eType;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_layout);
        extra =getIntent().getExtras();
        getWidget();


    }

    /**
     * initializes widgets.
     */
    public void getWidget()
    {
        btn_Create = (Button)   findViewById(R.id.btn_createEvent);
        btn_Cancel = (Button)   findViewById(R.id.btn_Cancel);
        btn_Cancel.setOnClickListener(this);
        btn_Create.setOnClickListener(this);
        startTimePicker = (TimePicker) findViewById(R.id.startTimePicker);
        endTimePicker = (TimePicker)    findViewById(R.id.endTimePicker);
        eventTypeGroup = (RadioGroup)   findViewById(R.id.eventTypeGroup);
        personalEvent = (RadioButton)   findViewById(R.id.personal);
        workEvent = (RadioButton)   findViewById(R.id.work);
        holidayEvent = (RadioButton)   findViewById(R.id.holiday);
        otherEvent = (RadioButton)   findViewById(R.id.other);
        txt_Title = (EditText)  findViewById(R.id.txt_editTitle);



    }

    @Override
    /**
     * Switch statement for different button presse. This also handles the category switch
     *
     */
    public void onClick(View view)
    {
        int selectedId = eventTypeGroup.getCheckedRadioButtonId();
        if(selectedId == personalEvent.getId())
            eType = EventType.PRIVATE;
        else if(selectedId == workEvent.getId())
                eType = EventType.WORK;
        else if(selectedId == holidayEvent.getId())
            eType = EventType.HOLIDAY;
        else if(selectedId == otherEvent.getId())
            eType = EventType.OTHER;

        Log.i("EventType", eType+"");

        switch (view.getId())
        {
            case R.id.btn_createEvent:
               eventTitle = txt_Title.getText().toString();
                eventDate = extra.getString("DateSelect");

                CalendarEvent tmpEvent= new CalendarEvent(eventTitle);

                eventTimeHR = startTimePicker.getCurrentHour();
                eventTimeMIN = startTimePicker.getCurrentMinute();

                tmpEvent.setStart(eventDate);

                endTimeHR = endTimePicker.getCurrentHour();
                endTimeMIN = endTimePicker.getCurrentMinute();
                try{
                    tmpEvent.setStartTime(eventTimeHR, eventTimeMIN);
                    tmpEvent.setEndTime(endTimeHR, endTimeMIN);
                }catch(ParseException e){}


                tmpEvent.setEventType(eType);
                

                //if(!EventManager.checkDayConflict(eventDate)){

                    EventManager.addEvent(tmpEvent);
                    this.finish();
                /*}else{


                     Toast.makeText(getApplicationContext(), "Event Not created. Time Conflict", Toast.LENGTH_LONG).show();

               }*/



                break;
            case R.id.btn_Cancel:
                this.finish();
                break;
            default:
                break;
        }
    }
}

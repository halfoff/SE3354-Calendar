package com.example.lee.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
    protected EditText txt_Time;
    private int indexOfAdd;
    private String eventTitle;
    private String eventTime;
    private String eventDate;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_layout);
        Bundle extra =getIntent().getExtras();
        eventDate = extra.getString("DateSelect");
        getWidget();


    }

    public void getWidget()
    {
        btn_Create = (Button)   findViewById(R.id.btn_createEvent);
        btn_Cancel = (Button)   findViewById(R.id.btn_Cancel);
        txt_Title = (EditText)  findViewById(R.id.txt_editTitle);
        txt_Time = (EditText)   findViewById(R.id.txt_editTime);



    }

    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.btn_createEvent:
                eventTitle = txt_Title.getText().toString();
                eventTime = txt_Time.getText().toString();
                CalendarEvent tmpEvent= new CalendarEvent();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                try {
                    Date tmpDate            =df.parse(eventDate + " " + eventTime);
                    tmpEvent.setStart(tmpDate);
                    tmpEvent.setTitle(eventTitle);
                }catch(ParseException e)
                {
                    System.out.println("Wrong format");
                }
                //indexOfAdd=EventManager.addEvent(new CalendarEvent());
                //System.out.println("Event Added "+EventManager.getEvent(indexOfAdd).toString());
                this.finish();
                break;
            case R.id.btn_Cancel:
                this.finish();
                break;
            default:
                break;
        }
    }
}

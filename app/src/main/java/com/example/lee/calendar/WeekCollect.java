package com.example.lee.calendar;

/**
 * Created by Jack on 12/5/2015.
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class WeekCollect
{
    public GregorianCalendar date;
    public String event_message = "";
    public static ArrayList<WeekCollect> date_collection_arr= new ArrayList<>();
    public WeekCollect(ArrayList<CalendarEvent>[] eventsOnWeek, GregorianCalendar firstDate)
    {
        this.date = firstDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<CalendarEvent> events_on_date;
        for(int i = 0; i<eventsOnWeek.length;i++)
        {
            events_on_date = eventsOnWeek[i];


        if(events_on_date.isEmpty()) {
            this.event_message = "No events on "+ formatter.format(date.getTime());
        } else {
            for(CalendarEvent calEvent : events_on_date) {
                //TODO: formatting for individual events
                this.event_message += formatter.format(date.getTime())+" "+calEvent.getTitle() +" " +calEvent.getStartTime()+" - "+calEvent.getEndTime()+ "\n";
            }
        }
        }
    }
}
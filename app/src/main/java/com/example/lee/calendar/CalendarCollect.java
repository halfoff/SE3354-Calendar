package com.example.lee.calendar;

import java.util.ArrayList;

public class CalendarCollect
{
    public String date = "";
    public String event_message = "";
    public static ArrayList<CalendarCollect> date_collection_arr= new ArrayList<CalendarCollect>();
    public CalendarCollect(String date,String event_message)
    {
        ArrayList<CalendarEvent> events_on_date;
        events_on_date = EventManager.getEventsOnDate(date);
        this.date = date;
        if(events_on_date == null) {
            this.event_message = "No events today";
        } else {
            for(CalendarEvent calEvent : events_on_date) {
                //TODO: formatting for individual events
                this.event_message += calEvent.getTitle() + "\n";
            }
        }

    }
}

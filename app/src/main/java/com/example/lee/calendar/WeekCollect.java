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
    public ArrayList<String> event_message = new ArrayList<>();
    public static ArrayList<WeekCollect> date_collection_arr= new ArrayList<>();
    public WeekCollect(ArrayList<CalendarEvent>[] eventsOnWeek, GregorianCalendar firstDate)
    {
        this.date = firstDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String curDay ="";

        ArrayList<CalendarEvent> events_on_date;
        for(int i = 0; i<eventsOnWeek.length;i++)
        {
            events_on_date = eventsOnWeek[i];
            curDay = formatter.format(date.getTime());


            if(events_on_date.isEmpty()) {
                this.event_message.add( "No events on "+curDay +"\n");
            } else {
                for(CalendarEvent calEvent : events_on_date) {
                    //TODO: formatting for individual events
                    event_message.add( curDay+" "+calEvent.getTitle() +" " +calEvent.getStartTime()+" - "+calEvent.getEndTime()+ "\n");
                }
            }
            date.add(GregorianCalendar.DAY_OF_MONTH,1);
        }
    }
}
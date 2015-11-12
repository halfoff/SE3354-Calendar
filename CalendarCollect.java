package com.example.lee.calendar;

import java.util.ArrayList;

public class CalendarCollect
{
    public String date = "";
    public String event_message = "";
    public static ArrayList<CalendarCollect> date_collection_arr= new ArrayList<CalendarCollect>();
    public CalendarCollect(String date,String event_message)
    {
        this.date = date;
        this.event_message = event_message;
        this.date_collection_arr = new ArrayList<>();
    }
}

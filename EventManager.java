package com.example.lee.calendar;

import java.util.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Jack
 * Event manager handles event interactions and changes.
 * 
 */
public class EventManager {
	
	static ArrayList<CalendarEvent> events;
	static String status;
	
	public static void init() {
		events = new ArrayList<CalendarEvent>();
		status = "";
	}
	

	

	
	/**
	 * 
	 * @param calEvent
	 * @return index where calEvent is located
	 */
	public static int addEvent(CalendarEvent calEvent) {
		insertEvent(calEvent);
		return events.indexOf(calEvent);
	}
	
	public static boolean removeEvent(int index) {
		if(events.isEmpty())
		{
			status = "Remove not successful. ArrayList is empty.";
			return false;
		}
			
		
		status = "Remove Successful. " + events.remove(index); 
		return true;
	}
	
	/**
	 * Gets event at index.
	 * @param index
	 * @return returns event at Index
	 */
	public static CalendarEvent getEvent(int index) {
		if(events.isEmpty())
		{
			status = "No events exist.";
			return null;
		}
			
		return events.get(index);
	}

	/**
	 * Date is a string that is expected in yyy-MM-dd format.
	 * the method will parse the date and return an arraylist of dates.
	 * @param date
	 * @return an arraylist of dates
	 */
	public static ArrayList<CalendarEvent> getEventsOnDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = dateFormat.parse(date);
			ArrayList<CalendarEvent> events_on_date = new ArrayList<CalendarEvent>();
			for(CalendarEvent calEvent : events) {
				//System.out.println(d.toString() + " - " + calEvent.getStart().toString());
				if(calEvent.getStart().equals(d))
					events_on_date.add(calEvent);
			}
			return events_on_date;
		} catch (java.text.ParseException e) {
			System.out.println("Parse Exception");
		}
		return null;
	}
	
	/**
	 * Adds calEvent to the Arraylist. Sorts arrayList if it is not empty. 
	 * @param calEvent
	 */
	private static void insertEvent(CalendarEvent calEvent) {
		if(events.isEmpty()) {
			events.add(calEvent);
			status = "Added event " + calEvent.getTitle();
			
		}else
		{
			events.add(calEvent);
			status = "Added event " + calEvent.getTitle() + "events sorted.";
			//Collections.sort(events);
			
		}
	
	
		
	}
	
	/**
	 * 
	 * @param event1
	 * @param event2
	 * @return status of conflict
	 * 
	 * 1 if event1 starts after event2 ends
	 * -1 if event 1 ends before event 2 starts
	 * 0 if there is any overlap between the two. 
	 */
	private static int checkIndividualConflict(CalendarEvent event1, CalendarEvent event2)
	{

			if(event1.getStart().after(event2.getEnd()))
			{
				return 1;
			}else if(event1.getEnd().before(event2.getStart()))
			{
				return -1;
			}else
				return 0;
		
	}

	public static boolean checkDayConflict(String date) {
        ArrayList<CalendarEvent> eod = EventManager.getEventsOnDate(date);
        for (int i = 0; i < eod.size(); i++) {

            for (int j = i + 1; j < eod.size(); j++) {
                if (checkIndividualConflict(eod.get(i), eod.get(j)) == 0) {
                    return true;
                }
            }

        }
        return false;
    }

	
	/**
	 * 
	 * @return status with detailed information
	 */
	public static String getStatus() {
		return status;
	}
	
	
	public static void loop() {
		//sleep(60000);
		Date current = new Date();
		if(current.after(EventManager.getEvent(events.size() - 1).getStart()));
			EventManager.onEvent();
	}
	
	public static void onEvent() {
		CalendarEvent calEvent = events.get(events.size() - 1);
		if(calEvent.getRepeat() == RepeatType.NO_REPEAT)
			return;
		Calendar cal = Calendar.getInstance();
		cal.setTime(calEvent.getStart());
		if(calEvent.getRepeat() == RepeatType.DAILY)
			cal.add(Calendar.DAY_OF_MONTH, 1);
		else if(calEvent.getRepeat() == RepeatType.WEEKLY)
			cal.add(Calendar.WEEK_OF_MONTH, 1);
		else if(calEvent.getRepeat() == RepeatType.MONTHLY)
			cal.add(Calendar.MONTH, 1);
		else if(calEvent.getRepeat() == RepeatType.YEARLY)
			cal.add(Calendar.YEAR, 1);
		calEvent.setStart(cal.getTime());
	}
}

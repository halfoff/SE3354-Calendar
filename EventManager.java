import java.util.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.ArrayList;

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
	 * @param d date for event
	 * @return an event with with a given date. 
	 */
	/*
	public static CalendarEvent createEvent( Calendar start, Date end)
	{
		CalendarEvent calEvent = new CalendarEvent("New Event", EventType.UNLABLED);
		calEvent.setStart(start);
		calEvent.setEnd(end);
		insertEvent(calEvent);
		return calEvent;
	}
	*/
	/**
	 * 
	 * @param title
	 * @param d
	 * @return create event with specified title and date.
	 */
	/*
	public static CalendarEvent createEvent(String title, Date start, Date end)
	{
		CalendarEvent calEvent = new CalendarEvent(title, EventType.UNLABLED);
		calEvent.setStart(start);
		calEvent.setEnd(end);
		insertEvent(calEvent);
		return calEvent;
	}
	*/
	
	/**
	 * 
	 * @param title
	 * @param d
	 * @param flag
	 * @return event with specified title, date, and type. 
	 */
	/*
	public static CalendarEvent createEvent(String title, Date start, Date end, EventType et)
	{
		CalendarEvent calEvent = new CalendarEvent(title, et);
		calEvent.setStart(start);
		calEvent.setEnd(end);
		insertEvent(calEvent);
		return calEvent;
	}
	*/
	
	public static void addEvent(CalendarEvent calEvent) {
		insertEvent(calEvent);
	}
	
	public static boolean removeEvent(int index) {
		if(events.isEmpty())
			return false;
		events.remove(index);
		return true;
	}
	
	public static CalendarEvent getEvent(int index) {
		if(events.isEmpty())
			return null;
		return events.get(index);
	}
	
	/**
	 * Adds calEvent to the Arraylist. Sorts arrayList if it is not empty. 
	 * @param calEvent
	 */
	private static void insertEvent(CalendarEvent calEvent) {
		if(events.isEmpty()) {
			events.add(calEvent);
			System.out.println("Added event " + calEvent.getTitle());
			return;
		}else
		{
			events.add(calEvent);
			Collections.sort(events);
			
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
	
	/**
	 * 
	 * @return status with detailed information
	 */
	public static String getStatus() {
		return status;
	}
	
	/**
	 * 
	 */
	public static void loop() {
		//sleep(60000);
		Date current = new Date();
		if(current.after(EventManager.getEvent(events.size() - 1).getStart().getTime()));
			EventManager.onEvent();
	}
	
	public static void onEvent() {
		CalendarEvent calEvent = events.get(events.size() - 1);
		if(calEvent.getRepeat() == RepeatType.NO_REPEAT)
			return;
		Calendar cal = Calendar.getInstance();
		cal.setTime(calEvent.getStart().getTime());
		if(calEvent.getRepeat() == RepeatType.DAILY)
			cal.add(Calendar.DAY_OF_MONTH, 1);
		else if(calEvent.getRepeat() == RepeatType.WEEKLY)
			cal.add(Calendar.WEEK_OF_MONTH, 1);
		else if(calEvent.getRepeat() == RepeatType.MONTHLY)
			cal.add(Calendar.MONTH, 1);
		else if(calEvent.getRepeat() == RepeatType.YEARLY)
			cal.add(Calendar.YEAR, 1);
		calEvent.setStart(cal);
	}
}

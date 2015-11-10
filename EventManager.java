import java.util.Date;
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
	
	EventManager() {
		events = new ArrayList<CalendarEvent>();
		status = "";
	}
	
	/**
	 * 
	 * @param d date for event
	 * @return an event with with a given date. 
	 */
	public static CalendarEvent createEvent( Date start, Date end)
	{
		CalendarEvent calEvent = new CalendarEvent("New Event", 0);
		calEvent.setStart(start);
		calEvent.setEnd(end);
		insertEvent(calEvent);
		return calEvent;
	}
	/**
	 * 
	 * @param title
	 * @param d
	 * @return create event with specified title and date.
	 */
	public static CalendarEvent createEvent(String title, Date start, Date end)
	{
		CalendarEvent calEvent = new CalendarEvent(title, 0);
		calEvent.setStart(start);
		calEvent.setEnd(end);
		insertEvent(calEvent);
		return calEvent;
	}
	
	
	/**
	 * 
	 * @param title
	 * @param d
	 * @param flag
	 * @return event with specified title, date, and type. 
	 */
	public static CalendarEvent createEvent(String title, Date start, Date end, int flag)
	{
		CalendarEvent calEvent = new CalendarEvent(title, flag);
		calEvent.setStart(start);
		calEvent.setEnd(end);
		insertEvent(calEvent);
		return calEvent;
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
	
	public static void insertEvent(CalendarEvent calEvent) {
		if(events.isEmpty())
			events.add(calEvent);
		int i = 0;
		for(; i < events.size(); ++i) {
			if(calEvent.compareTo(events.get(i)) > 0)
				events.add(i, calEvent);
				return;
		}
		if(checkIndividualConflict(calEvent, events.get(i)) == 0)
			status = "Conflict between " + calEvent.getTitle() + " and " + events.get(i);
		else
			status = "";
		events.add(calEvent);
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
	public static int checkIndividualConflict(CalendarEvent event1, CalendarEvent event2)
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
		if(current.after(EventManager.getEvent(0).getStart()));
			EventManager.onEvent();
	}
	
	public static void onEvent() {
		
	}
}

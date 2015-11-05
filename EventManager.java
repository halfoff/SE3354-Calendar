import java.util.Date;

/**
 * 
 * @author Jack
 * Event manager handles event interactions and changes.
 * 
 */
public interface EventManager {
	
	
	
	/**
	 * 
	 * @param d date for event
	 * @return an event with with a given date. 
	 */
	public static CalendarEvent createEvent( Date d)
	{
		return new CalendarEvent("New Event", d, 0);
	}
	/**
	 * 
	 * @param title
	 * @param d
	 * @return create event with specified title and date.
	 */
	public static CalendarEvent createEvent(String title, Date d)
	{
		return new CalendarEvent(title, d, 0);
	}
	
	
	/**
	 * 
	 * @param title
	 * @param d
	 * @param flag
	 * @return event with specified title, date, and type. 
	 */
	public static CalendarEvent createEvent(String title, Date d, int flag)
	{
		return new CalendarEvent(title, d, flag);
	}
	
	public static boolean checkIndividualConflict(CalendarEvent event1, CalendarEvent event2)
	{
		if(event1.compareTo(event2) == 0)
			return true;
		return false;
	}	
	
	/** 
	 * Override this method. Replace o with the data structure that you are using to store
	 * the events. Then implement the most applicable way to search through the object and check
	 *Don't forget you can use the compareTo method from CalendarEvent to check the conflict. 
	 * @return
	 */
	public static boolean checkTotalConflict(CalendarEvent event1, Object o)
	{
		return false;
	}
	

}

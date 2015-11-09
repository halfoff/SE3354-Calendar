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
	

	

}

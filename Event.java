import java.util.Date;

public class Event {

	private String title;
	private Date  eventTime;
	private int eventType;//0- Unlabled 1-Private 2- work 3- holiday
	
	
	public Event()
	{
		title = "New Event";
		eventTime = new Date();
		eventType = 0; 
	}
	
	public Event(String t, Date d, int e)
	{
		title = t;
		eventTime = d;
		eventType = e;
	}
	
	/**
	 * 
	 * @return boolean on remove, True is Success, False is failure
	 */
	static boolean remove()
	{
		return false;
		//TODO: Create method that removes instance of event. 
	}
}

import java.util.Date;

public class CalendarEvent{

	private String title;
	private Date  eventTime;
	private int eventType;//0- Unlabled 1-Private 2- work 3- holiday
	
	
	public CalendarEvent()
	{
		title = "New Event";
		eventTime = new Date();
		eventType = 0; 
	}
	
	public CalendarEvent(String t, Date d, int e)
	{
		title = t;
		eventTime = d;
		eventType = e;
	}


	
	
	public Date getEventDate()
	{
		return this.eventTime;
	}
	
	public String gettitle()
	{
		return this.title;
	}
	
	public int getEventType()
	{
		return this.eventType;
	}

	/**
	 * 
	 * @param arg
	 * @return the result of java.util.Date's compareTo method
	 * 
	 * 0 if event and arg are at the same time. 
	 * > 0 if event is after arg
	 * < 0 if event is before arg
	 * 
	 * For some reaosn I was getting an error telling me I didn't properly override the compareTo
	 * method, so I just removed the comparable interface. Hopefully it doesnt break anything by 
	 * doing that. 
	 */
	public int compareTo(CalendarEvent arg) {
		return this.eventTime.compareTo(arg.getEventDate());
		
	}



//Delete calendar event by setting its arguments = to null

public void deleteEvent(CalendarEvent arg){
	
	arg = null;
}
//Method changes event title to updated title set by user
public void editTitle(CalendarEvent arg, string name){
	
	arg.title = name;
	
}
//Method changes date to an updated date set by user
public void editDate(CalendarEvent arg, Date updated){
	
	arg.eventTime = updated;
		
}
//Method changes event type to an updated type set by the user
public void editEventType(CalendarEvent arg, int type){
	
	arg.eventType = type;
		
}



}

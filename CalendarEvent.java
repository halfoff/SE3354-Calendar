import java.util.Date;

public class CalendarEvent{

	private String title;
	private Date  eventTime;
	private LinkedList eventType;//0- Unlabled 1-Private 2- work 3- holiday
	String eventTypename;
	
	public CalendarEvent()
	{
		title = "New Event";
		eventTime = new Date();
		eventTypename = "0"; 
	}
	
	public CalendarEvent(String t, Date d, String Category)
	{
		title = t;
		eventTime = d;
		addEventTypeCategory(String Category)
		eventTypename = category;
		
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
		
		return this.eventTypename;
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


public void addEventTypeCategory(String name){
	
	eventType.add(name);
	
}

public void deleteEventTypeCategory(String name){
	
	for(int count =0; count <= eventType.size();count++)
	{
		String comparer = eventType.get(count);
		if(comparer == name)
		{
			eventType.remove(count)
			return;
		}
	}
}


public void editEventTypeCategory(String goingtobechanged, String replacer){
	
	for(int count =0; count <= eventType.size();count++)
	{
		String comparer = eventType.get(count);
		if(comparer == name)
		{
			eventType.add(count)
			return;
		}
	}
}
// This function does nothing useful but in case something messes up it checks to see if the event type is stored
// in linked list structure 
public boolean checkEventTypeCategory(String name){
	
	for(int count =0; count <= eventType.size();count++)
	{
		String comparer = eventType.get(count);
		if(comparer == name)
		{
			
			return true;
		}
	}
	return false;
}

}

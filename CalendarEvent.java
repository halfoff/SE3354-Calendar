import java.util.Date;


public class CalendarEvent implements Comparable<CalendarEvent>{

	private String title;
	private Date eventStart;
	private Date eventEnd;
	private EventType eventType;
	private RepeatType repeat; 
	
	/*private LinkedList eventType;//0- Unlabled 1-Private 2- work 3- holiday
	String eventTypename;*/
	
	public CalendarEvent()
	{
		title = "New Event";
		eventStart = new Date();
		eventEnd = new Date();
		eventType = EventType.UNLABLED;
		repeat = RepeatType.NO_REPEAT;
	}
	
	public CalendarEvent(String t, EventType et)
	{
		// here we are looking if the category is in the linked list if it is then we do nothing and simply set name
		// else we have to add the category to the linked list structure and set the event's category type to it. 
		title = t;
		//eventStart = d;
		eventType = et;
		/*for(int count =0; count <= eventType.size();count++)
	{
		String comparer = eventType.get(count);
		if(comparer == name)
		{
		addEventTypeCategory(String Category)	
			return;
		}
	}
		
		eventTypename = category;*/
		
	}


	public RepeatType getRepeat()
	{
		return this.repeat;
	}
	
	public void setRepeat(RepeatType rt) {
		this.repeat = rt;
	}

	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String new_title) {
		this.title = new_title;
	}
	
	public EventType getEventType()
	{
		
		return this.eventType;
	}
	
	public int setEventType(){
		
		this.eventType = new_category;
	}
	
	public void setStart(Date new_start) {
		this.eventStart = new_start;
	}
	
	public void setEnd(Date new_end) {
		this.eventEnd = new_end;
	}

	/**
	 * 
	 * @param arg
	 * @return the result of java.util.Date's compareTo method
	 * This compares the start date of two CalendarEvents.
	 * 0 if event and arg are at the same time. 
	 * > 0 if event is after arg
	 * < 0 if event is before arg
	 * 
	 *  
	 */
	public int compareTo(CalendarEvent arg)
	{
		return this.getStart().compareTo(arg.getStart());
	}
	



	public Date getEnd()
	{
		return this.eventEnd;
	}
	public Date getStart() {
			// TODO Auto-generated method stub
			return this.eventStart;
	}

//Delete calendar event by setting its arguments = to null

public void deleteEvent(CalendarEvent arg){
	
	arg = null;
}
//Method changes event title to updated title set by user
public void editTitle(CalendarEvent arg, String name){
	
	arg.title = name;
	
}

/*public void addEventTypeCategory(String name){
	
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
}*/

}

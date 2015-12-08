package com.example.lee.calendar;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class CalendarEvent implements Comparable<CalendarEvent>, java.io.Serializable{


	private String title;
	private Date eventStart;
	private Date eventEnd;
	private EventType eventType;
	private RepeatType repeat;
	private String startTime;
	private String endTime;
	
	/*private LinkedList eventType;//0- Unlabled 1-Private 2- work 3- holiday
	String eventTypename;*/

	/**
	 * default constructor for calendar event.
	 */

	public CalendarEvent()
	{
		title = "New Event";
		eventStart = new Date();
		eventEnd = new Date();
		startTime = "12:00";
		endTime = "01:00";
		eventType = EventType.UNLABLED;
		repeat = RepeatType.NO_REPEAT;
	}

	/**
	 * Constructor for calendar event with user defined title.
	 * @param t
	 */
	public CalendarEvent(String t) {
		this.title = t;
		repeat = RepeatType.NO_REPEAT;
		eventType = EventType.UNLABLED;
	}

	/**
	 * Contstructor for calendar event with user defined title and event type.
	 * @param t
	 * @param et
	 */
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

	/**
	 * Overwritten version of the tostring.
	 *
	 * @return String in format of "Title: [title] Date: [date]
	 */
	public String toString() {
		return "Title: " + this.title + " Date: " + this.eventStart.toString();
	}

	/**
	 *
	 * @return returns repeat type
	 */
	public RepeatType getRepeat()
	{
		return this.repeat;
	}

	/**
	 * Sets repeat type.
	 * @param rt
	 */
	public void setRepeat(RepeatType rt) {
		this.repeat = rt;
	}

	/**
	 *
	 * @return returns title of event.
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * Change title of event.
	 * @param new_title
	 */
	public void setTitle(String new_title) {
		this.title = new_title;
	}

	/**
	 *
	 * @return event type
	 */
	public EventType getEventType()
	{

		return this.eventType;
	}

	/**
	 * Sets new event type
	 * @param eT
	 */
	public void setEventType(EventType eT){

		this.eventType = eT;
	}

	/**
	 * Sets start time for event as a string in the formation of hour:min
	 * @param hour
	 * @param min
	 */
	public void setStartTime(int hour, int min)
	{
		String mins=min+"";
		if(min <10 && min>=0)
		{
			mins = "0"+min;
		}
		startTime = hour +":"+ mins;
	}

	/**
	 * Sets end time for event as a string in the formation of hour:min
	 * @param hour
	 * @param min
	 */
	public void setEndTime(int hour, int min)
	{
		String mins=min+"";
		if(min <10 && min>=0)
		{
			mins = "0"+min;
		}
		endTime = hour +":"+ mins;
	}

	/**
	 *
	 * @return start time of event as string in the form of HR:MIN
	 */
	public String getStartTime(){
		return startTime;
	}

	/**
	 *
	 * @return end time of event as string int he form of HR:MIN
	 */
	public String getEndTime()
	{
		return endTime;
	}

	/**
	 *
	 * @param date
	 */
	public void setStart(String date) {
		//Calendar cal = Calendar.getInstance();
		//cal.set(year, month, date);
		//this.eventStart = cal;

		//SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d;
		try {
			d = dateFormat.parse(date);
			setStart(d);
		} catch(java.text.ParseException e) {

		}
	}

	public void setStart(Date new_cal) {
		this.eventStart = new_cal;
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

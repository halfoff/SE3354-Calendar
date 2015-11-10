import java.util.Date;

public class MyCalendar {

	public static void main(String[] args) {
		System.out.println("Testing calendar");
		EventManager.init();
		CalendarEvent event1 = new CalendarEvent();
		event1.setTitle("Event 1");
		event1.setStart(2015, 1, 1);
		//event1.setEnd(2015, 1, 2);
		CalendarEvent event2 = new CalendarEvent();
		event2.setTitle("Event 2");
		event2.setStart(2015, 1, 3);
		//event2.setEnd(2015, 1 ,4);
		CalendarEvent event3 = new CalendarEvent();
		event3.setTitle("Event 3");
		event3.setStart(2015, 1, 5);
		//event3.setEnd(2015, 1, 6);
		EventManager.addEvent(event1);
		EventManager.addEvent(event3);
		EventManager.addEvent(event2);
		
		System.out.println(event1.compareTo(event2));
		System.out.println(event2.compareTo(event2));
		System.out.println(event3.compareTo(event1));
		
		
		for(int i = 0; i < 3; ++i) {
			System.out.println(EventManager.getEvent(i).toString());
		}
		
	}

}

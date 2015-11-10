import java.util.Date;

public class Calendar {

	public static void main(String[] args) {
		System.out.println("Testing calendar");
		EventManager.init();
		CalendarEvent event1 = new CalendarEvent();
		event1.setTitle("Event 1");
		event1.setStart(new Date(1));
		event1.setEnd(new Date(2));
		CalendarEvent event2 = new CalendarEvent();
		event2.setTitle("Event 2");
		event2.setStart(new Date(3));
		event2.setEnd(new Date(4));
		CalendarEvent event3 = new CalendarEvent();
		event3.setTitle("Event 3");
		event3.setStart(new Date(5));
		event3.setEnd(new Date(6));
		EventManager.addEvent(event1);
		EventManager.addEvent(event3);
		EventManager.addEvent(event2);
		
		System.out.println(event1.compareTo(event2));
		System.out.println(event2.compareTo(event2));
		System.out.println(event3.compareTo(event1));
		
		
		for(int i = 0; i < 3; ++i) {
			System.out.println(EventManager.getEvent(i).getTitle());
		}
		
	}

}

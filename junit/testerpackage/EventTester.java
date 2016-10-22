package testerpackage;

import java.text.ParseException;
import eventfactory.model.Event;
import junit.framework.TestCase;

public class EventTester extends TestCase {
	Event testEvent;
	public EventTester() throws ParseException{
		testEvent = new Event("Dinner", "Food", "Desc", "102220160530", "102220160700");
		//this.testEvent = testEvent;
	}
	
	public void testEventName() throws Exception {
		assertEquals("Dinner", testEvent.getName());
	}
	
	public void testEventDescription() throws Exception {
		assertEquals("Food", testEvent.getDescription());
	}
	
	public void testEventStart() throws Exception {
		assertEquals("102220160530", testEvent.getTime().getStartAll());
	}
	
	public void testEventEnd() throws Exception {
		assertEquals("102220160700", testEvent.getTime().getEndAll());
	}
}

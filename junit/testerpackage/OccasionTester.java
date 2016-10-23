package testerpackage;

import java.text.ParseException;

import eventfactory.model.Event;
import eventfactory.model.Occasion;
import junit.framework.TestCase;

public class OccasionTester extends TestCase{
	Occasion occasionTest;
	
	public OccasionTester() throws ParseException{
		occasionTest = new Occasion("YCPHacks", "Yorktowne Hotel", "Description", "102220160530", "112120170700");
	}
	
	public void testOccasionName() throws Exception {
		assertEquals("YCPHacks", occasionTest.getName());
	}
	
	public void testOccasionLocation() throws Exception {
		assertEquals("Yorktowne Hotel", occasionTest.getLocation());
	}
	
	public void testOccasionStart() throws Exception {
		assertEquals("102220160530", occasionTest.getTime().getStartAll());
	}
	
	public void testOccasionEnd() throws Exception {
		assertEquals("112120170700", occasionTest.getTime().getEndAll());
	}
	public void testOccasionEvents() throws Exception {
		occasionTest.getEvents().add(new Event("Dinner", "Dining Hall", "Eating Food", "102220161500", "102220161630"));
		occasionTest.getEvents().add(new Event("Breakfast", "Bed", "Pigging Out", "102320160800", "102320160930"));
		occasionTest.getEvents().add(new Event("Lunch", "Cafeteria", "Feast", "102320161200", "102320161330"));
		
		assertEquals("Dinner", occasionTest.getEvents().get(0).getName());
		assertEquals("Breakfast", occasionTest.getEvents().get(1).getName());
		assertEquals("Lunch", occasionTest.getEvents().get(2).getName());
		
		assertEquals("Dining Hall", occasionTest.getEvents().get(0).getLocation());
		assertEquals("Bed", occasionTest.getEvents().get(1).getLocation());
		assertEquals("Cafeteria", occasionTest.getEvents().get(2).getLocation());
		
		assertEquals("Eating Food", occasionTest.getEvents().get(0).getDescription());
		assertEquals("Pigging Out", occasionTest.getEvents().get(1).getDescription());
		assertEquals("Feast", occasionTest.getEvents().get(2).getDescription());
		
		assertEquals("102220161500", occasionTest.getEvents().get(0).getTime().getStartAll());
		assertEquals("102320160800", occasionTest.getEvents().get(1).getTime().getStartAll());
		assertEquals("102320161200", occasionTest.getEvents().get(2).getTime().getStartAll());
		
		assertEquals("102220161630", occasionTest.getEvents().get(0).getTime().getEndAll());
		assertEquals("102320160930", occasionTest.getEvents().get(1).getTime().getEndAll());
		assertEquals("102320161330", occasionTest.getEvents().get(2).getTime().getEndAll());
	}
	public void testOccasionJsonParser() throws Exception{
		occasionTest.getEvents().add(new Event("test name", "test loc", "test desc", "102120162100", "102320161300"));
		assertEquals("{\"oname\":\"YCPHacks\",\"olocation\":\"Yorktowne Hotel\",\"startSource\":\"102220160530\",\"endSource\":\"112120170700\",\"events\":[{\"name\":\"test name\",\"description\":\"test desc\",\"location\":\"test loc\",\"startSource\":\"102120162100\",\"endSource\":\"102320161300\"}]}", occasionTest.toJSON());
	}
	
}

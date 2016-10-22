package testerpackage;

import java.text.ParseException;

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
}

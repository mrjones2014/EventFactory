package testerpackage;
import java.text.ParseException;

import eventfactory.model.TimeDate;
import junit.framework.TestCase;
public class TimeDateTester extends TestCase{
	TimeDate timeTest;
	public TimeDateTester() throws ParseException{
		timeTest = new TimeDate();
		timeTest.setStartDate("102220160530");
		timeTest.setEndDate("112120170700");
	}
	
	public void testStartTimeMonth() throws Exception {
		assertEquals(10, timeTest.getStartMonth());
	}
	
	public void testStartTimeDay() throws Exception {
		assertEquals(22, timeTest.getStartDay());
	}
	
	public void testStartTimeYear() throws Exception {
		assertEquals(2016, timeTest.getStartYear());
	}
	
	public void testStartTimeHour() throws Exception {
		assertEquals(05, timeTest.getStartHours());
	}
	
	public void testStartTimeMinute() throws Exception {
		assertEquals(30, timeTest.getStartMinutes());
	}
	
	public void testEndTimeMonth() throws Exception {
		assertEquals(11, timeTest.getEndMonth());
	}
	
	public void testEndTimeDay() throws Exception {
		assertEquals(21, timeTest.getEndDay());
	}
	
	public void testEndTimeYear() throws Exception {
		assertEquals(2017, timeTest.getEndYear());
	}
	
	public void testEndTimeHour() throws Exception {
		assertEquals(07, timeTest.getEndHours());
	}
	
	public void testEndTimeMinute() throws Exception {
		assertEquals(00, timeTest.getEndMinutes());
	}
}

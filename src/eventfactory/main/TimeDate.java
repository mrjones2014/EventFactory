package eventfactory.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDate {
	private Date startDate;
	private Date endDate;
	private SimpleDateFormat formatTime;
	
	public TimeDate(){
		formatTime = new SimpleDateFormat("MMddyyyyHHmm");
	}
	//getters for specific substrings of the dates
	public int getStartMonth(){
		return Integer.parseInt(formatTime.format(startDate).substring(0, 2));
	}
	public int getStartDay(){
		return Integer.parseInt(formatTime.format(startDate).substring(2, 4));
	}
	public int getStartYear(){
		return Integer.parseInt(formatTime.format(startDate).substring(4, 8));
	}
	public int getStartHours(){
		return Integer.parseInt(formatTime.format(startDate).substring(8, 10));
	}
	public int getStartMinutes(){
		return Integer.parseInt(formatTime.format(startDate).substring(10, 12));
	}
	public int getEndMonth(){
		return Integer.parseInt(formatTime.format(endDate).substring(0, 2));
	}
	public int getEndDay(){
		return Integer.parseInt(formatTime.format(endDate).substring(2, 4));
	}
	public int getEndYear(){
		return Integer.parseInt(formatTime.format(endDate).substring(4, 8));
	}
	public int getEndHours(){
		return Integer.parseInt(formatTime.format(endDate).substring(8, 10));
	}
	public int getEndMinutes(){
		return Integer.parseInt(formatTime.format(endDate).substring(10, 12));
	}
	public void setStartDate(String source) throws ParseException{
		startDate = formatTime.parse(source);
	}
	public void setEndDate(String source) throws ParseException{
		endDate = formatTime.parse(source);
	}
}

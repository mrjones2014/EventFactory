package eventfactory.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Occasion{
	private boolean notification;
	private TimeDate time;
	private String name;
	private String description;
	public Event(String name, String description, boolean notification) throws ParseException{
		this.notification = notification;
		this.description = description;
		this.name = name;
		this.time = new TimeDate();
	}
	
	
	//basic getters,setters
	public boolean getNotification(){
		return this.notification;
	}
	public TimeDate getTime(){
		return time;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}
	public void setNotification(boolean notification){
		this.notification = notification;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDescription(String description){
		this.description = description;
	}
}

package eventfactory.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Occasion{
	private Notification notification;
	private TimeDate time;
	private String name;
	private String description;
	public Event(){
		this.time = new TimeDate();
	}
	
	
	//basic getters,setters
	public Notification getNotification(){
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
	public void setNotification(Notification notification){
		this.notification = notification;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDescription(String description){
		this.description = description;
	}
}

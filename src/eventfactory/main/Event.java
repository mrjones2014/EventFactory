package eventfactory.main;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Occasion{
	private boolean isSubscribed;
	private TimeDate time;
	private String name;
	private String description;
	private String color;
	public Event(String name, String description) throws ParseException{
		isSubscribed = true;
		this.description = description;
		this.name = name;
		this.time = new TimeDate();
		
	}
	
	
	//basic getters,setters
	public boolean isSubscribed(){
		return this.isSubscribed;
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
	public void setSubscribed(boolean status){
		this.isSubscribed = status;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDescription(String description){
		this.description = description;
	}
}

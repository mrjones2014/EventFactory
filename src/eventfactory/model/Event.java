package eventfactory.model;
import java.text.ParseException;

import com.google.gson.Gson;

public class Event extends Occasion{
	private boolean isSubscribed;
	private TimeDate time;
	private String name;
	private String description;
	private String location;
	
	public Event(String name, String location, String description, String startSource, String endSource) throws ParseException{
		isSubscribed = true;
		this.description = description;
		this.name = name;
		this.time = new TimeDate();
		time.setStartDate(startSource);
		time.setEndDate(endSource);
		this.location = location;
	}

	public static Event fromJson(String json){
		Gson gson = new Gson();
		return gson.fromJson(json, Event.class);
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
	public String getLocation(){
		return location;
	}
	public void setLocation(String loc){
		this.location = loc;
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
	
	public String toJSON(){
		String accumulator = "";
		accumulator=accumulator.concat("{\"name\":");
		accumulator=accumulator.concat("\"" + this.getName() + "\",");
		accumulator=accumulator.concat("\"description\":");
		accumulator=accumulator.concat("\"" + this.getDescription() + "\",");
		accumulator=accumulator.concat("\"location\":");
		accumulator=accumulator.concat("\"" + this.getLocation() + "\",");
		accumulator=accumulator.concat("\"startSource\":");
		accumulator=accumulator.concat("\"" + this.getTime().getStartAll() + "\",");
		accumulator=accumulator.concat("\"endSource\":");
		accumulator=accumulator.concat("\"" + this.getTime().getEndAll() + "\"}");
		return accumulator;
	}
}

package eventfactory.model;

import java.text.ParseException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Occasion {
	private ArrayList<Event> events;
	private TimeDate time;
	private String location;
	private String description;
	private String name;
	public Occasion(){
		
	}
	public Occasion(String name, String location, String description, String startSource, String endSource) throws ParseException{
		events = new ArrayList<Event>();
		this.time = new TimeDate();
		this.setName(name);
		this.location = location;
		time.setStartDate(startSource);
		time.setEndDate(endSource);
		this.description = description;
		//time.setStartDate("102120162100");
		//time.setEndDate("102320161300");
	}
	
	public static Occasion fromJson(String json){
		Gson gson = new Gson();
		return gson.fromJson(json, Occasion.class);
	}
	
	public ArrayList<Event> getEvents(){
		return this.events;
	}
	public TimeDate getTime(){
		return this.time;
	}
	public String getLocation(){
		return location;
	}
	public void setLocation(String loc){
		this.location = loc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toJSON(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	public String eventListAsJSON(){
		Gson gson = new Gson();
		return gson.toJson(events.toArray());
	}
}

package eventfactory.model;

import java.text.ParseException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Occasion {
	private ArrayList<Event> events;
	private TimeDate time;
	private String location;
	private String name;
	public Occasion(){
		
	}
	public Occasion(String name, String location, String startSource, String endSource) throws ParseException{
		events = new ArrayList<Event>();
		this.time = new TimeDate();
		this.setName(name);
		this.location = location;
		time.setStartDate(startSource);
		time.setEndDate(endSource);
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
	
	public String occasionToJSON(){
		String accumulator = "";
		accumulator.concat("{\"name\":");
		accumulator.concat("\"" + this.getName() + "\",");
		accumulator.concat("{\"location\":");
		accumulator.concat("\"" + this.getLocation() + "\",");
		accumulator.concat("{\"startSource\":");
		accumulator.concat("\"" + this.getTime().getStartAll() + "\",");
		accumulator.concat("{\"endSource\":");
		accumulator.concat("\"" + this.getTime().getEndAll() + "\",");
		accumulator.concat("{\"events\":");
		accumulator.concat("[");
		for(int i = 0; i < events.size(); i ++){
			accumulator.concat("[");
			accumulator.concat("{\"name\":");
			accumulator.concat("\"" + this.getEvents().get(i).getName() + "\",");
			accumulator.concat("{\"description\":");
			accumulator.concat("\"" + this.getEvents().get(i).getDescription() + "\",");
			accumulator.concat("{\"location\":");
			accumulator.concat("\"" + this.getEvents().get(i).getLocation() + "\",");
			accumulator.concat("{\"startSource\":");
			accumulator.concat("\"" + this.getEvents().get(i).getTime().getStartAll() + "\",");
			accumulator.concat("{\"endSource\":");
			accumulator.concat("\"" + this.getEvents().get(i).getTime().getEndAll() + "\",");
			accumulator.concat("]");
		}
		accumulator.concat("]");
		
		
		
		
		
		return accumulator;
		
		
		//Gson gson = new Gson();
		//return gson.toJson(events.toArray());
	}
}

package eventfactory.model;

import java.text.ParseException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Occasion {
	private ArrayList<Event> events;
	private TimeDate otime;
	private String olocation;
	private String odescription;
	private String oname;
	public Occasion(){
		
	}
	public Occasion(String name, String location, String description, String startSource, String endSource) throws ParseException{
		events = new ArrayList<Event>();
		this.otime = new TimeDate();
		this.setName(name);
		this.olocation = location;
		otime.setStartDate(startSource);
		otime.setEndDate(endSource);
		this.odescription = description;
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
		return this.otime;
	}
	public String getLocation(){
		return olocation;
	}
	public void setLocation(String loc){
		this.olocation = loc;
	}
	public String getName() {
		return oname;
	}
	public void setName(String name) {
		this.oname = name;
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
			accumulator.concat("\"" + this.getEvents().get(i).getTime().getEndAll() + "\"");
			accumulator.concat("]");
		}
		accumulator.concat("]}");
		
		return accumulator;
	}
}

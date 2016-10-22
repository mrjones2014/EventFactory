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
	
	public String toJSON(){
		String accumulator = "";
		accumulator=accumulator.concat("{\"name\":");
		accumulator=accumulator.concat("\"" + this.getName() + "\",");
		accumulator=accumulator.concat("\"location\":");
		accumulator=accumulator.concat("\"" + this.getLocation() + "\",");
		accumulator=accumulator.concat("\"startSource\":");
		accumulator=accumulator.concat("\"" + this.getTime().getStartAll() + "\",");
		accumulator=accumulator.concat("\"endSource\":");
		accumulator=accumulator.concat("\"" + this.getTime().getEndAll() + "\",");
		accumulator=accumulator.concat("{\"events\":");
		accumulator=accumulator.concat("[");
		for(int i = 0; i < events.size(); i ++){
			accumulator=accumulator.concat("{\"name\":");
			accumulator=accumulator.concat("\"" + this.getEvents().get(i).getName() + "\",");
			accumulator=accumulator.concat("\"description\":");
			accumulator=accumulator.concat("\"" + this.getEvents().get(i).getDescription() + "\",");
			accumulator=accumulator.concat("\"location\":");
			accumulator=accumulator.concat("\"" + this.getEvents().get(i).getLocation() + "\",");
			accumulator=accumulator.concat("\"startSource\":");
			accumulator=accumulator.concat("\"" + this.getEvents().get(i).getTime().getStartAll() + "\",");
			accumulator=accumulator.concat("\"endSource\":");
			accumulator=accumulator.concat("\"" + this.getEvents().get(i).getTime().getEndAll() + "\"");
		}
		accumulator=accumulator.concat("]");
		accumulator=accumulator.concat("}");
		
		return accumulator;
	}
}

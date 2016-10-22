package eventfactory.main;

import java.text.ParseException;
import java.util.ArrayList;

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
	
}

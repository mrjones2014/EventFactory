package eventfactory.main;

import java.text.ParseException;
import java.util.ArrayList;

public class Occasion {
	private ArrayList<Event> events;
	private TimeDate time;
	public Occasion() throws ParseException{
		events = new ArrayList<Event>();
		this.time = new TimeDate();
		time.setStartDate("102120162100");
		time.setEndDate("102320161300");
	}
	public ArrayList<Event> getEvents(){
		return this.events;
	}
	public TimeDate getTime(){
		return this.time;
	}
}

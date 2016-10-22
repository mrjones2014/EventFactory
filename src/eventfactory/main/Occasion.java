package eventfactory.main;

import java.util.ArrayList;

public class Occasion {
	private ArrayList<Event> events;
	private TimeDate time;
	public Occasion(){
		events = new ArrayList<Event>();
		this.time = new TimeDate();
	}
	public ArrayList<Event> getEvents(){
		return this.events;
	}
	public TimeDate getTime(){
		return this.time;
	}
}

package eventfactory.app_name;

import java.util.ArrayList;
import java.util.Collection;

public class Occasion {
    private String title, description, location;
    private ArrayList<Event> events;

    public Occasion(String title, String description, String location){
        this.title = title;
        this.description = description;
        this.location = location;
        this.events = new ArrayList<>();
    }

    public Occasion(String title, String description, String location, ArrayList<Event> events){
        this.title = title;
        this.description = description;
        this.location = location;
        this.events = events;
    }

    public void addEvent(Event e){
        events.add(e);
    }

    public void addAllEvents(Collection<Event> e){
        events.addAll(e);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}

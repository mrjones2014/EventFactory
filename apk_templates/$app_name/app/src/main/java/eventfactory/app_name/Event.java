package eventfactory.app_name;

import java.text.ParseException;

import com.google.gson.Gson;

public class Event extends Occasion{
    private boolean isSubscribed;
    private TimeDate time;
    private String name;
    private String description;
    private String location;

    public Event(String name, String description, String startSource, String endSource) throws ParseException{
        isSubscribed = true;
        this.description = description;
        this.name = name;
        this.time = new TimeDate();
        time.setStartDate(startSource);
        time.setEndDate(endSource);
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
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

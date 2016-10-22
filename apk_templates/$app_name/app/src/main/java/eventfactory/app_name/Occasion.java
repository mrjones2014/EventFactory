package eventfactory.app_name;

import java.text.ParseException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Occasion {
    private ArrayList<Event> events;
    private TimeDate otime;
    private String olocation;
    private String oname;
    public Occasion(){

    }
    public Occasion(String name, String location, String startSource, String endSource) throws ParseException{
        events = new ArrayList<Event>();
        this.otime = new TimeDate();
        this.setName(name);
        this.olocation = location;
        otime.setStartDate(startSource);
        otime.setEndDate(endSource);
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
}

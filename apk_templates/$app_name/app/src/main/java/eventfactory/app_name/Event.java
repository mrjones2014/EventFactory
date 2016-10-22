package eventfactory.app_name;

import java.util.Date;

public class Event {
    Date start, end;
    String name, description;
    Boolean isSubscribed;

    public Event(Date start, Date end, String name, String description, Boolean isSubscribed){
        this.start = start;
        this.end = end;
        this.name = name;
        this.description = description;
        this.isSubscribed = isSubscribed;
    }
}

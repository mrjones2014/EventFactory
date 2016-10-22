package eventfactory.app_name;

import java.util.Date;

public class Event {
    private Date start, end;
    private String name, description, location;
    private Boolean isSubscribed;

    public Event(Date start, Date end, String name, String description, String location, Boolean isSubscribed){
        this.start = start;
        this.end = end;
        this.name = name;
        this.description = description;
        this.location = location;
        this.isSubscribed = isSubscribed;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }
}

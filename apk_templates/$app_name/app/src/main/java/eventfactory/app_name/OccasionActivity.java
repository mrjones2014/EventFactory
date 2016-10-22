package eventfactory.app_name;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.MissingResourceException;

public class OccasionActivity extends AppCompatActivity {
    private Occasion occasion;
    private TableLayout eventsTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occasion);
        eventsTable = (TableLayout) findViewById(R.id.eventsTable);
        try {
            loadEvents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        populateEventTable();
    }

    public void loadEvents() throws FileNotFoundException, MissingResourceException, JSONException, ParseException {
        /*File eventsFile = new File("events.json");
        if(!eventsFile.exists()) throw new MissingResourceException("Resource \"events.json\" missing. ", "OccasionActivity","events.json");
        else{*/
            JSONObject jsonObj = new JSONObject("{\"oname\":\"test name\",\"olocation\":\"test loc\",\"startSource\":\"102120162100\",\"endSource\":\"102320161300\",\"events\":[{\"name\":\"test name\",\"description\":\"test desc\",\"location\":\"test loc\",\"startSource\":\"102120162100\",\"endSource\":\"102320161300\"}]}");
            occasion = new Occasion((String)jsonObj.get("oname"), (String)jsonObj.get("olocation"), (String)jsonObj.get("startSource"), (String)jsonObj.get("endSource"));
        JSONArray eventsJson = jsonObj.getJSONArray("events");
        for(int i = 0; i < eventsJson.length(); i ++){
            JSONObject singleEventJson = eventsJson.getJSONObject(i);
            Event e = new Event(singleEventJson.getString("name"), singleEventJson.getString("description"), singleEventJson.getString("location"), singleEventJson.getString("startSource"), singleEventJson.getString("endSource"));
            occasion.getEvents().add(e);
        }
        /*}*/
    }
    //{"name":"test name","location":"test loc","startSource":"102120162100","endSource":"102320161300",{"events":[{"name":"test name","description":"test desc","location":"test loc","startSource":"102120162100","endSource":"102320161300"]}
    public void populateEventTable(){
        for(int i = 0; i < occasion.getEvents().size(); i ++){
            TableRow newRow = new TableRow(this);
            Event currentEvent = occasion.getEvents().get(i);
            String startTime = formatTimeString(currentEvent.getTime().getStartHours(), currentEvent.getTime().getStartMinutes());
            String endTime = formatTimeString(currentEvent.getTime().getEndHours(), currentEvent.getTime().getEndMinutes());

            TextView tvStart = new TextView(this);
            tvStart.setText(startTime);

            TextView tvEnd = new TextView(this);
            tvEnd.setText(endTime);

            TextView tvEventTitle = new TextView(this);
            tvEventTitle.setText(currentEvent.getName());

            TextView tvEventLocation = new TextView(this);
            tvEventLocation.setText(currentEvent.getLocation());

            newRow.addView(tvStart);
            newRow.addView(tvEnd);
            newRow.addView(tvEventTitle);
            newRow.addView(tvEventLocation);

            eventsTable.addView(newRow);
        }
    }

    public static String padStringLength(String string, int length) {
        return String.format("%1$-"+length+ "s", string).substring(0, length);
    }

    public String formatTimeString(int hour, int minute){
        Boolean isAm = true;
        if(hour > 12){
            isAm = false;
            hour -= 12;
        } else if(hour == 12) isAm = false;

        return isAm ? hour + ":" + new DecimalFormat("00").format(minute) + "AM" : hour + ":" + new DecimalFormat("00").format(minute) + "PM";
    }
}

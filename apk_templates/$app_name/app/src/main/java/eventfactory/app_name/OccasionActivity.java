package eventfactory.app_name;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

public class OccasionActivity extends AppCompatActivity {
    Occasion occasion;
    ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occasion);
        eventListView = (ListView) findViewById(R.id.eventListView);
        populateEventListView();
    }

    public Boolean loadEvents() throws FileNotFoundException, MissingResourceException {
        File eventsFile = new File("events.json");
        if(!eventsFile.exists()) throw new MissingResourceException("Resource \"events.json\" missing. ", "OccasionActivity","events.json");
        else{
            Gson gson = new Gson();
            occasion = gson.fromJson(new FileReader("events.json"), Occasion.class);
        }
        return true;
    }

    public void populateEventListView(){
        ArrayList<String> listStringData = new ArrayList<>();
        for(int i = 0; i < 10;/*occasion.getEvents().size();*/ i++){
            /*String startTime = formatTimeString(occasion.getEvents().get(i).getTime().getStartHours(), occasion.getEvents().get(i).getTime().getStartMinutes());
            String endTime = formatTimeString(occasion.getEvents().get(i).getTime().getEndHours(), occasion.getEvents().get(i).getTime().getEndMinutes());
            String duration = padStringLength(startTime + "-" + endTime, 11);
            String eventTitle = padStringLength(occasion.getEvents().get(i).getName(), 20);
            String eventLocation = padStringLength(occasion.getEvents().get(i).getName(), 20);

            String fullEventString = duration + eventTitle + eventLocation;*/
            String fullEventString = padStringLength("7:45AM-9:00AM", 11) + padStringLength("test event", 20) + padStringLength("test location", 20);
            listStringData.add(fullEventString);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.simple_list_item_1, listStringData);
        eventListView.setAdapter(arrayAdapter);
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

        return isAm ? hour + ":" + minute + "AM" : hour + ":" + minute + "PM";
    }
}

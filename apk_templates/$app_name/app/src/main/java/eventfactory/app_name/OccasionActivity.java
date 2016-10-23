package eventfactory.app_name;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
        scheduleAllNotifications();
    }

    public void loadEvents() throws Exception {
        //example JSON string to test with:
        // "{\"oname\":\"test name\",\"olocation\":\"test loc\",\"startSource\":\"102120162100\",\"endSource\":\"102320161300\",\"events\":[{\"name\":\"test name\",\"description\":\"test desc\",\"location\":\"test loc\",\"startSource\":\"102120162100\",\"endSource\":\"102320161300\"}]}"
        //String[] assetList = getAssets().list("");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("JSON.json")));

            // do reading, usually loop until end of file reading
            String accum = "";
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                accum += mLine;
            }
            JSONObject jsonObj = new JSONObject(accum);
            occasion = new Occasion(jsonObj.getString("oname"), jsonObj.getString("olocation"), jsonObj.getString("startSource"), jsonObj.getString("endSource"));
            JSONArray eventsJson = jsonObj.getJSONArray("events");
            for(int i = 0; i < eventsJson.length(); i ++){
                JSONObject singleEventJson = eventsJson.getJSONObject(i);
                Event e = new Event(singleEventJson.getString("name"), singleEventJson.getString("description"), singleEventJson.getString("location"), singleEventJson.getString("startSource"), singleEventJson.getString("endSource"));
                occasion.getEvents().add(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void populateEventTable(){
        if(occasion != null){
            Collections.sort(occasion.getEvents(), new Comparator<Event>() {
                @Override
                public int compare(Event lhs, Event rhs) {
                    return lhs.getTime().getStartDate().compareTo(rhs.getTime().getStartDate());
                }
            });
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
    }

    public String formatTimeString(int hour, int minute){
        Boolean isAm = true;
        if(hour > 12){
            isAm = false;
            hour -= 12;
        } else if(hour == 12) isAm = false;
        else if(hour == 0) hour+=12;

        return isAm ? hour + ":" + new DecimalFormat("00").format(minute) + "AM" : hour + ":" + new DecimalFormat("00").format(minute) + "PM";
    }

    @TargetApi(23)
    public void scheduleNotification(Date dateTime, String title, String message)
    {

        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        alarmIntent.putExtra("message", message);
        alarmIntent.putExtra("title", title);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = getSystemService(AlarmManager.class);

        //TODO: For demo set after 5 seconds.
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, dateTime.getTime(), pendingIntent);
    }

    private void scheduleAllNotifications(){
        if(occasion != null){
            for(int i = 0; i < occasion.getEvents().size(); i ++){
                scheduleNotification(occasion.getEvents().get(i).getTime().getStartDate(), occasion.getEvents().get(i).getName(), occasion.getEvents().get(i).getDescription());
            }
        }
    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String getStringFromFile(String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return ret;
    }
}

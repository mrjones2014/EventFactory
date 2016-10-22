package eventfactory.app_name;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }

    public Boolean loadEvents(){
        File eventsFile = new File("events.json");
        if(!eventsFile.exists()) return false;
        else{
            
        }
        return true;
    }
}

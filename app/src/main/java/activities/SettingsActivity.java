package activities;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.game.R;
import settings.UserSettings;

//GameActivity class is a subclass of AppCompatActivity class
//so we are extending AppCompatActivity methods
public class SettingsActivity extends AppCompatActivity {

    @Override
    //onCreate(Bundle savedInstanceState)
    //method is responsible to create the activity and save it`s orientation
    protected void onCreate(Bundle savedInstanceState) {
        //We use super.onCreate() to run onCreate parent-class methods
        super.onCreate(savedInstanceState);
        //setContentView() is filling our activity "window" with content form XML source
        setContentView(R.layout.activity_settings);

        //initializing (assigning) our buttons from XML source
        final Button btn_apply = findViewById(R.id.btn_apply);
        final Button btn_cancel = findViewById(R.id.btn_cancel);
        final EditText et_speed = findViewById(R.id.et_speed);
        final EditText et_time = findViewById(R.id.et_time);

        //setting btn_apply event Listener
        btn_apply.setOnClickListener(new View.OnClickListener() {
            //onClick() method define click event handler for a button
            public void onClick(View v) {
                //setting balls falling speed
                UserSettings.setSpeed(et_speed.getText().toString());
                //setting game time
                UserSettings.setTime(et_time.getText().toString());
                finish();
            }
        });
        //setting btn_cancel event Listener
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            //onClick() method define click event handler for a button
            public void onClick(View v) {
                finish();
            }
        });
        //speed input label
        et_speed.setText(UserSettings.getSpeed() + "");
        //time input label
        et_time.setText(UserSettings.getTime() + "");

    }
}

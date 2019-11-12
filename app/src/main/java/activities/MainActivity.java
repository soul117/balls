package activities;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import com.example.game.R;
import data.PlayerInfo;
import data.Record;
import settings.ApplicationSettings;

//MainActivity class is a subclass of AppCompatActivity class
//so we are extending AppCompatActivity methods
public class MainActivity extends AppCompatActivity {
    @Override
    //onCreate(Bundle savedInstanceState)
    //method is responsible to create the activity and save it`s orientation
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting the orientation to landscape (always vertical)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //setContentView() is filling our activity "window" with content form XML source
        setContentView(R.layout.activity_main);

        //initializing (assigning) our buttons from XML source
        final Button button_start = findViewById(R.id.btn_start);
        final Button button_records = findViewById(R.id.btn_records);
        final Button button_settings = findViewById(R.id.btn_settings);
        final Button button_exit = findViewById(R.id.btn_exit);

        //setting button_start event Listener
        button_start.setOnClickListener(new View.OnClickListener() {
        //onClick() method define click event handler for a button
            public void onClick(View v) {
                //players score set to 0
                PlayerInfo.setScore(0);
                //start GameActivity
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
        //setting button_records event Listener
        button_records.setOnClickListener(new View.OnClickListener() {
            //onClick() method define click event handler for a button
            public void onClick(View v) {
                //start RecordsActivity
                startActivity(new Intent(MainActivity.this, RecordsActivity.class));
            }
        });
        //setting button_settings event Listener
        button_settings.setOnClickListener(new View.OnClickListener() {
            //onClick() method define click event handler for a button
            public void onClick(View v) {
                //start SettingsActivity
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
        //setting button_exit event Listener
        button_exit.setOnClickListener(new View.OnClickListener() {
            //onClick() method define click event handler for a button
            public void onClick(View v) {
                //exit game
                onBackPressed();
            }
        });

        //in this part we get height and width of our screen
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        //screen height
        int height = metrics.heightPixels;
        //screen width
        int width = metrics.widthPixels;
        //then setting application screen height and width
        ApplicationSettings.setScreenWidth(width);
        ApplicationSettings.setScreenHeight(height);
        //resetting user actions (clicks on screen)
        PlayerInfo.resetUserActions();
    }

    @Override
    //onBackPressed definition - means exit game
    public void onBackPressed() {
        //alert dialog message
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Are you sure you want to exit? message
        builder.setMessage("Are you sure you want to exit?")
                //sets whether this dialog is cancelable -false
                .setCancelable(false)
                //"Yes" button
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(startMain);
                        finish();
                    }
                })
                //"No" button to cancel dialog
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        //show alert message
        AlertDialog alert = builder.create();
        alert.show();


    }
}

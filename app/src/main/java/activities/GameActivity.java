package activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import data.PlayerInfo;
import data.Record;
import logic.GameView;

//GameActivity class is a subclass of AppCompatActivity class
//so we are extending AppCompatActivity methods
public class GameActivity extends AppCompatActivity {
    private static GameActivity gameActivity;
    //declaring gameview
    private GameView gameView;

    @Override
    //onCreate(Bundle savedInstanceState)
    //method is responsible to create the activity and save it`s orientation
    protected void onCreate(Bundle savedInstanceState) {
        //We use super.onCreate() to run onCreate parent-class methods
        super.onCreate(savedInstanceState);
        //setGameActivity can refer to GameActivity
        GameActivity.setGameActivity(this);
        //Initializing game view object
        gameView = new GameView(this);
        //adding it to contentview
        setContentView(gameView);
    }

    //pausing the game when activity is paused
    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    //running the game when activity is resumed
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

    @Override
    //destroy our activity - means to terminate activity
    protected void onDestroy() {
        super.onDestroy();
        setGameActivity(null);
    }

    //show saved result
    public static void showSaveResult() {
        //if activity really present
        //then call show result
        if (getGameActivity() != null) {
            getGameActivity().saveResult();
        }
    }

    public static void backPressed() {
        //if activity really present
        //then back to previous activity
        if (getGameActivity() != null) {
            getGameActivity().finish();
        }
    }

    //save result
    public void saveResult() {
        //alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //dialog message
        builder.setMessage("Your current result is: " + PlayerInfo.getScore() + "\nDo you wat to save result?")
                //we can cancel that dialog
                .setCancelable(false)
                //Yes button
                //
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //add new record to player info
                        PlayerInfo.addRecord(new Record(PlayerInfo.getNickname(), PlayerInfo.getScore()));
                        //reset Player score
                        PlayerInfo.resetScore();
                        //return to previous activity
                        finish();
                        //popup message with "Result saved!"
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Result saved!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                })
                //No button
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //return to previous activity
                        finish();
                        //reset Player score
                        PlayerInfo.resetScore();

                    }
                });
        //alert dialog
        AlertDialog alert = builder.create();
        //show alert
        alert.show();
    }

    //GameActivity getter
    public static GameActivity getGameActivity() {
        return gameActivity;
    }

    //GameActivity setter
    public static void setGameActivity(GameActivity gameActivity) {
        GameActivity.gameActivity = gameActivity;
    }
}


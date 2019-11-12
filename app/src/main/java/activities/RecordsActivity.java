package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.game.R;

import java.util.ArrayList;
import java.util.List;

import data.PlayerInfo;
import data.Record;

//RecordsActivity class is a subclass of AppCompatActivity class
//so we are extending AppCompatActivity methods
public class RecordsActivity extends AppCompatActivity {
    //context initialization
    private Context context = null;

    @Override
    //onCreate(Bundle savedInstanceState)
    // method is responsible to create the activity and save it`s orientation
    protected void onCreate(Bundle savedInstanceState) {
        //We use super.onCreate() to run onCreate parent-class methods
        super.onCreate(savedInstanceState);
        //setContentView() is filling our activity "window" with content form XML source
        setContentView(R.layout.activity_records);

        //get TableLayout object in layout style
        final TableLayout tableLayout = (TableLayout) findViewById(R.id.table_layout_table);
        final ImageView button_onBackPress = findViewById(R.id.btn_onBackPress);

        button_onBackPress.setOnClickListener(new View.OnClickListener() {
            //onClick() method define click event handler for a button
            public void onClick(View v) {
                //return to previous activity
                finish();
            }
        });

        context = getApplicationContext();
        //if there are no records
        if (PlayerInfo.getRecords().size() > 0) {
            // Create a new table row.
            for (Record record : PlayerInfo.getRecords()) {
                //update table
                TableRow tableRow = new TableRow(context);

                // Set new table row layout parameters.
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                tableRow.setLayoutParams(layoutParams);

                // Add a TextView in the first column.
                TextView tv_nickname = new TextView(context);
                // get players nickname string
                tv_nickname.setText(record.getNickname());
                //set positioning of new row - CENTER
                tv_nickname.setGravity(Gravity.CENTER);
                //players nickname index
                tableRow.addView(tv_nickname, 0);

                // Add a TextView in the second column
                TextView tv_score = new TextView(context);
                //get players score
                tv_score.setText(record.getScore() + "");
                //score index
                tableRow.addView(tv_score, 1);

                tableLayout.addView(tableRow);
            }
        } else {
            TableRow tableRow = new TableRow(context);
            // Set new table row layout parameters.
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(layoutParams);

            // Add a TextView in the first column.
            TextView tv_nickname = new TextView(context);
            //set text string "There are no records here yet!"
            tv_nickname.setText("There are no records here yet!");
            //text parameters
            tv_nickname.setGravity(Gravity.CENTER);
            //font
            tv_nickname.setTextSize(19);
            //index
            tableRow.addView(tv_nickname, 0);

            tableLayout.addView(tableRow);
        }


    }
}

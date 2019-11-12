package models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import activities.GameActivity;
import logic.GameView;
import logic.IGameLogic;
import settings.ApplicationSettings;
import settings.UserSettings;

//Label class is a subclass of AGameObject class
//so we are extending AGameObject methods
public class Label extends AGameObject {
    {
        //"this" is setting "LABEL" as a type of current class Ball
        this.setType("LABEL");
    }

    //initializing variables
    private String text;
    private int fontSize = 60;
    private float y = 80;
    private long whenEndTime;

    //
    public Label(IGameLogic gameView) {
        this(gameView, new Point(ApplicationSettings.getScreenWidth() - 60 * 7, 0));
    }

    public Label(IGameLogic gameView, Point position) {
        this.setGameView(gameView);

        // text drawing
        //set drawing parameters
        this.setPaint(new Paint(Paint.ANTI_ALIAS_FLAG));
        this.getPaint().setTextSize(fontSize);

        //set label properties
        this.setWidth(fontSize * 7);
        this.setHeight(fontSize);
        this.setBounds(new Rect((int) position.x, (int) position.y, (int) position.x + width, (int) position.y + height));

        //setting time when time expires
        this.whenEndTime = System.currentTimeMillis() + UserSettings.getTime() * 1000;
    }

    //basket click handler
    //(if user click on label call this method)
    @Override
    public void onClick(Object sender, Object event) {

    }

    //time update
    //to view each second
    @Override
    public void update() {
        //updating times left label
        //long currentTimeMillis ()-Returns the current time in milliseconds.
        long millis = System.currentTimeMillis();
        //getting current time
        //to know when game actually ends
        long diff = (whenEndTime - millis) / 1000;
        //when that difference ==0 - stop game
        //then show popup window with request
        //save score or not
        if (diff <= 0) {
            GameView.setPlaying(false);
            //calling popup menu from main thread
            GameActivity.getGameActivity().runOnUiThread(new Runnable() {
                public void run() {
                    //show that window
                    GameActivity.showSaveResult();
                }
            });
        }

        //set timer value
        text = String.valueOf("Time left: " + diff);
        //update game bounds every frame
        //due to the change in the length of the text
        this.setBounds(new Rect(getBounds().left, getBounds().top, getBounds().left + getWidth(), getBounds().top + getHeight()));
    }

    @Override
    public void draw(Canvas canvas) {
        //drawn text
        //translate() is drawing again same object
        canvas.translate(50, y);
        //setting positioning where we will draw it
        canvas.drawText(text, ApplicationSettings.getScreenWidth() - fontSize * 7, 0, getPaint());
        //google canvas translate!!!!
    }
}

package models;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

import data.PlayerInfo;
import logic.GameView;

import com.example.game.R;

import logic.IGameLogic;
import settings.ApplicationSettings;
import settings.UserSettings;
import tools.BitmapScaler;

//Class Ball extends AGameObject
//so Ball is a subclass of AGameObject class
public class Ball extends AGameObject {
    {
        //"this" is setting "BALL" as a type of current class Ball
        this.setType("BALL");
    }

    //initializing variables
    private int radius;
    private float speedRate;
    private Bascket b = null;
    private int clickOnBascket = 0;

    //constructors
    public Ball(IGameLogic gameView) {
        this(gameView, UserSettings.getSpeed());
    }

    public Ball(IGameLogic gameView, float speed) {
        this(gameView, speed, 75);
    }

    public Ball(IGameLogic gameView, float speed, int radius) {
        this(gameView, speed, radius, Color.WHITE);
    }

    public Ball(IGameLogic gameView, float speed, int radius, int color) {
        this(gameView, speed, radius, color, R.drawable.ball);
    }

    //finally constructors initialized
    public Ball(IGameLogic gameView, float speed, int radius, int color, int resource_id) {
        this.setGameView(gameView);

        this.speedRate = speed;
        this.radius = radius;
        this.setWidth(radius * 2);
        this.setHeight(radius * 2);

        this.setResourceId(resource_id);
        //loading our images from res/draw
        this.setImage(BitmapFactory.decodeResource(getGameView().getContext().getResources(), resource_id));
        //scaling image by width
        this.setImage(BitmapScaler.scaleToFitWidth(getImage(), getWidth()));
        //positioning ball (center)
        this.setPositionF(new PointF(ApplicationSettings.getScreenWidth() / 2 - radius, 0));
        this.setBounds(new Rect((int) positionF.x, (int) positionF.y, (int) positionF.x + getWidth(), (int) positionF.y + getHeight()));
        //ball color and draw
        this.setPaint(new Paint());
        this.getPaint().setColor(color);
    }

    //basket click handler
    //(if user click on ball call this method)
    @Override
    public void onClick(Object sender, Object event) {

    }

    public void setBascket(Bascket bascket) {
        // check if basket wans`t clicked before
        if (clickOnBascket == 0) {
            //counter
            clickOnBascket++;
            //running whereto move method from Gameview class
            this.b = bascket;
        }
    }

    //updating ball state
    @Override
    public void update() {
        //X and Y step (speed)
        double deltaX = 0;
        double deltaY = 0;
        double angle;
        //ball positioning by default ball is falling down to screen
        double x = 0;
        double y = speedRate;
        //if we really click on basket
        //we are getting its coordinates
        if (b != null) {
            //calculating distance from basket center to our ball
            deltaX = (b.getPositionF().x + b.getWidth() / 2) - this.getPositionF().x;
            deltaY = (b.getPositionF().y + b.getHeight() / 2) - this.getPositionF().y;
            //calculating way to basket from top
            angle = Math.atan2(deltaY, deltaX);
            //calculating actual falling speed and next coordinate to basket
            //imagine triangle
            x = speedRate * Math.cos(angle);
            y += speedRate * Math.sin(angle);
        }
        //getting number of units do we need to shift ball
        //and setting new position to ball every each frame it falling
        //current coordinates + speed
        //bring it to float because for more precision
        this.setPositionF(new PointF(positionF.x + (float) x, positionF.y + (float) y));
        this.setBounds(new Rect(
                //ball hitbox
                getPosition().x,
                getPosition().y,
                getPosition().x + getWidth(),
                getPosition().y + getHeight()));
        //if distance between ball and basket <100
        //ball is actually inside basket (bounds)
        if ((b != null && deltaX < 100 && deltaY < 100) ||
                //or ball simple fall down
                this.getBounds().top > ApplicationSettings.getScreenHeight()) {
            //if we actually click on box or not?
            if (b != null) {
                //if color of ball and basket are equals
                //then increase score by 2 points (green ball and green box)
                if ((b.getResourceId() == R.drawable.box_green && this.getResourceId() == R.drawable.ball_green) ||
                        //red ball == red box
                        (b.getResourceId() == R.drawable.box_red && this.getResourceId() == R.drawable.ball_red)) {
                    PlayerInfo.addScore(2);
                } else {
                    //decrease score by 1
                    PlayerInfo.subScore(1);
                }
            } else {
                //if ball was skipped - decrease score by 2
                PlayerInfo.subScore(2);
            }
            //generating new ball/ getting ball instance
            this.getGameView().createNewBallRandomly(null, this);
        }
    }

    //drawing ball
    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(getImage(), null, getBounds(), getPaint());
    }
}

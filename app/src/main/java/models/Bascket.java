package models;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;

import com.example.game.R;

import logic.GameView;
import logic.IGameLogic;
import settings.ApplicationSettings;
import tools.BitmapScaler;

//Class Bascket extends AGameObject
//so Bascket is a subclass of AGameObject class
public class Bascket extends AGameObject {
    {
        //"this" is setting "BASCKET" as a type of current class Ball
        this.setType("BASCKET");
    }

    //constructors
    public Bascket(IGameLogic gameView) {
        this(gameView, new PointF(0, ApplicationSettings.getScreenHeight() - 300), 300, 300);
    }

    //constructors
    public Bascket(IGameLogic gameView, PointF position, int width, int height) {
        this(gameView, position, width, height, R.drawable.box_green);
    }

    //constructors
    //last Basket constructor getting all parameters
    public Bascket(IGameLogic gameView, PointF position, int width, int height, int recource_id) {
        this.setGameView(gameView);

        this.setResourceId(recource_id);
        this.setImage(BitmapFactory.decodeResource(getGameView().getContext().getResources(), recource_id));
        this.setImage(BitmapScaler.scaleToFitWidth(getImage(), width));
        this.setPositionF(position);
        this.setWidth(width);
        this.setHeight(height);
        this.setBounds(new Rect((int) position.x, (int) position.y, (int) position.x + width, (int) position.y + height));
        this.setPaint(new Paint());
        this.getPaint().setColor(Color.WHITE);
    }

    //basket click handler
    //(if user click on basket call this method)
    @Override
    public void onClick(Object sender, Object event) {
        //get ball object
        Ball ball = getGameView().getFirstBall();

        //check if ball object exist
        if (ball != null) {
            //tell the ball to fly to this basket
            ball.setBascket(this);
        }
    }

    //nothing to update because baskets are state still (no changes)
    @Override
    public void update() {
    }

    //basket drawing
    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(getImage(), null, getBounds(), getPaint());
    }
}

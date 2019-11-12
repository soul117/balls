package models;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;

import com.example.game.R;

import activities.GameActivity;
import data.PlayerInfo;
import logic.GameView;
import logic.IGameLogic;
import settings.ApplicationSettings;
import tools.BitmapScaler;

public class Button extends AGameObject {
    {
        //"this" is setting "BUTTON" as a type of current class Button
        this.setType("BUTTON");
    }

    //constructors
    public Button(IGameLogic gameView) {
        this(gameView, new PointF(0, ApplicationSettings.getScreenHeight() - 300), 300, 300);
    }

    //constructors
    public Button(IGameLogic gameView, PointF position, int width, int height) {
        this(gameView, position, width, height, R.drawable.box_green);
    }

    //constructors
    //last Button constructor getting all parameters
    public Button(IGameLogic gameView, PointF position, int width, int height, int recource_id) {
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


    @Override
    public void onClick(Object sender, Object event) {
        //clear user data
        PlayerInfo.resetUserActions();

        //stop game thread
        GameView.setPlaying(false);
        //call method on ui(main) thread
        GameActivity.getGameActivity().runOnUiThread(new Runnable() {
            public void run() {
                //show that window
                GameActivity.backPressed();
            }
        });
    }

    //nothing to update because baskets are state still (no changes)
    @Override
    public void update() {
    }

    //button drawing
    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(getImage(), null, getBounds(), getPaint());
    }
}

package models;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;

import logic.IGameLogic;

//Here we are initializing some valuables
//AGameObject class is implementing IGameObject interface
public abstract class AGameObject implements IGameObject {
    protected String type;
    protected IGameLogic gameView;
    protected int resourceId;
    protected Bitmap image;
    protected Point position;
    protected PointF positionF;
    protected int width;
    protected int height;
    // Needed for Canvas.drawOval
    protected Rect bounds;
    // The paint (e.g. style, color) used for drawing
    protected Paint paint;

    //Type getter
    public String getType() {
        return type;
    }
    //Type setter
    public void setType(String type) {
        this.type = type;
    }
    //HameView getter
    public IGameLogic getGameView() {
        return gameView;
    }
    //GameView setter
    public void setGameView(IGameLogic gameView) {
        this.gameView = gameView;
    }
    //ResourceId getter
    public int getResourceId() {
        return resourceId;
    }
    //ResourceId setter
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    //Image getter
    public Bitmap getImage() {
        return image;
    }
    //Image setter
    public void setImage(Bitmap image) {
        this.image = image;
    }
    //Position getter
    public Point getPosition() {
        return position;
    }
    //PositionF getter
    public PointF getPositionF() {
        return positionF;
    }
    //PositionF setter
    public void setPositionF(PointF positionF) {
        this.positionF = positionF;
        this.position = new Point((int) positionF.x, (int) positionF.y);
    }
    //Width getter
    public int getWidth() {
        return width;
    }
    //Width setter
    public void setWidth(int width) {
        this.width = width;
    }
    //Height getter
    public int getHeight() {
        return height;
    }
    //Height setter
    public void setHeight(int height) {
        this.height = height;
    }
    //Bounds getter
    public Rect getBounds() {
        return bounds;
    }
    //Bounds setter
    public void setBounds(Rect bounds) {
        this.bounds = bounds;
    }
    //Paint getter
    public Paint getPaint() {
        return paint;
    }
    //Paint setter
    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}

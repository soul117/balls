package models;
import android.graphics.Canvas;
import android.graphics.Color;

//Here is a GameObject interface
//which contains update() and draw() methods
public interface IGameObject {
    void update();
    void draw(Canvas canvas);
    void onClick(Object sender, Object event);
}

package logic;

import android.content.Context;

import java.util.ArrayList;

import models.Ball;

//Here is a GameLogic interface
//which contain screateNewBallRandomly(), whereToMove() and isClickOnBascket() methods
public interface IGameLogic {
    void createNewBallRandomly(Context context, Ball ball);

    void isClickOn(String typeOfObject);

    Ball getFirstBall();

    void userActionDispatcher();

    Context getContext();
}

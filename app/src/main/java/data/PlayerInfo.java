package data;

import android.graphics.Point;

import java.util.ArrayList;

public class PlayerInfo {
    //initializing players info
    //Player`s nickmane - Player
    private static String nickname = "Player";
    //Player`s score - o
    private static int score = 0;
    //creating new array list of records for Player
    private static ArrayList<Record> records = new ArrayList<>();

    //Player activity system information
    //click coordinates x and y axis
    private static Point userClickCoordinates;
    private static int motionEvent;
    //Check is screen clicked
    private static boolean isClicked = false;
    //Clicks count
    private static int clickCount = 0;


    //nickname getter
    public static String getNickname() {
        return nickname;
    }

    //nickname setter
    public static void setNickname(String nickname) {
        PlayerInfo.nickname = nickname;
    }

    //score getter
    public static int getScore() {
        return score;
    }

    //resetting player`s score to 0
    public static void resetScore() {
        PlayerInfo.score = 0;
    }

    //new player`s score
    public static void addScore(int score) {
        if (score >= 0) {
            PlayerInfo.score += score;
        }
    }

    //players`s subScore
    public static void subScore(int score) {
        //if score >=0 and PlayerInfo.score>=0
        if (score >= 0 && PlayerInfo.score >= 0) {
            //and their difference >=0
            if (PlayerInfo.score - score >= 0) {
                //PlayerInfo.score = PlayerInfo.score - score
                PlayerInfo.score -= score;
            } else {
                //set score 0
                PlayerInfo.score = 0;
            }
        }
    }

    //set player score
    public static void setScore(int score) {
        //if PlayerInfo.score - score >= 0
        if (PlayerInfo.score - score >= 0) {
            //assign PlayerInfo.score score value
            PlayerInfo.score = score;
        }
    }

    //player`s ArrayList<Record> getter
    public static ArrayList<Record> getRecords() {
        return records;
    }

    //player`s ArrayList<Record> setter
    public static void setRecords(ArrayList<Record> records) {
        //assign PlayerInfo.score records value
        PlayerInfo.records = records;
    }

    //add new player`s record
    public static void addRecord(Record record) {
        //if there are no record
        if (record != null) {
            //add new record to playerInfo
            PlayerInfo.records.add(record);
        }
    }

    //return user click coordinates on screen
    //if the user has not clicked before, returns a point with coordinates -1 -1
    public static Point getUserClickCoordinates() {
        if (userClickCoordinates == null) {
            userClickCoordinates = new Point(-1, -1);
        }

        return userClickCoordinates;
    }

    //set user click coordinates
    public static void setUserClickCoordinates(Point clickCoordinates) {
        PlayerInfo.userClickCoordinates = clickCoordinates;
    }

    //returns a boolean indicating whether the screen was clicked
    public static boolean isPlayerClick() {
        return isClicked;
    }

    //set value
    public static void playerClickOnScreen(boolean isClicked) {
        PlayerInfo.isClicked = isClicked;
    }

    //return  how many times user click on screen
    public static int getClickCount() {
        return clickCount;
    }

    //set value
    public static void setClickCount(int clickCount) {
        PlayerInfo.clickCount = clickCount;
    }

    public static int getMotionEvent() {
        return motionEvent;
    }

    public static void setMotionEvent(int motionEvent) {
        PlayerInfo.motionEvent = motionEvent;
    }


    //resetting player`s actions (clicks on screen)
    public static void resetUserActions() {
        PlayerInfo.setUserClickCoordinates(new Point(-1, -1));
        PlayerInfo.playerClickOnScreen(false);
        PlayerInfo.setClickCount(0);
    }
}

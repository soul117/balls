package settings;

public class UserSettings {
    //initializing  time and speed valuables
    private static int time = 10;
    private static int speed = 30;

    //time getter
    public static int getTime() {
        return time;
    }
    //time setter
    public static void setTime(int time) {
        UserSettings.time = time;
    }
    //if user input wrong data like "!@#$" or figures with "."
    //it will be parsed to normal numbers
    public static void setTime(String time) {
        UserSettings.time = (int)Double.parseDouble(time);
    }
    //speed getter
    public static int getSpeed() {
        return speed;
    }
    //speed setter
    public static void setSpeed(int speed) {
        UserSettings.speed = speed;
    }
    //if user input wrong data like "!@#$" or figures with "."
    //it will be parsed to normal numbers
    public static void setSpeed(String speed) {
        UserSettings.speed = (int)Double.parseDouble(speed);
    }
}

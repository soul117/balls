package settings;
//ApplicationSettings
public class ApplicationSettings {
    //initializing screenWidth and screenHeight valuables
    private static int screenWidth = 1080;
    private static int screenHeight = 1920;

    //screenWidth getter
    public static int getScreenWidth() {
        return screenWidth;
    }
    //screenWidth setter
    public static void setScreenWidth(int screenWidth) {
        ApplicationSettings.screenWidth = screenWidth;
    }
    //screenHeight getter
    public static int getScreenHeight() {
        return screenHeight;
    }
    //screenHeight setter
    public static void setScreenHeight(int screenHeight) {
        ApplicationSettings.screenHeight = screenHeight;
    }
}

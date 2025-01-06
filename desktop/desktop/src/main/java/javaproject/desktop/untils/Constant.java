package javaproject.desktop.untils;

public class Constant {

    public static final String BASE_URL = "http://localhost:9999/";
    private static String TOKEN;
    private static boolean changed;
    private Constant() {
    }

    // Getter và Setter cho TOKEN
    public static String getToken() {
        return TOKEN;
    }

    public static void setToken(String token) {
        Constant.TOKEN = token;
    }

    public static boolean isChanged() {
        return changed;
    }

    public static void setChanged(boolean changed) {
        Constant.changed = changed;
    }
}

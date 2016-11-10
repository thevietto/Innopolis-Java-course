package inno;

/**
 * Created by vietto on 10.11.16.
 */
public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

}

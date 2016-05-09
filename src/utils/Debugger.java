package utils;

/**
 * Created by Radu on 5/9/16.
 */
public class Debugger {
    public static boolean isEnabled() {
        return true;
    }

    public static void log(Object o){
        if(Debugger.isEnabled()) {
            System.out.println(o.toString());
        }
    }
}

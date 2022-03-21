package lt.codeacademy.utils;

public class UniqueNumberTracker {
    private static long counter;

    public static long getCounter(){
        counter++;
        return counter;
    }

    public static void resetCounter(){
        counter = 0;
    }
}

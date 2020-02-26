package Programowanie2Luty.SingletonyExamples;

public class SingletonEager {
    private static final double wartoscSingleton = 9.98;

    private SingletonEager() {
    }

    public static double plusujZSingleton(int x){
        return x + wartoscSingleton;
    }
    public static double plusujZSingleton(double x){
        return x + wartoscSingleton;
    }
    public static double minusujZSingleton(int x){
        return x - wartoscSingleton;
    }
    public static double minusujZSingleton(double x){
        return x - wartoscSingleton;
    }

}

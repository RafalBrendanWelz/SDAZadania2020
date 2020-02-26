package Programowanie2Luty.SingletonyExamples;

public class SingletonDoubleChecked {
    private static SingletonDoubleChecked INSTANCE;
    private double wartoscSingleton;

    private SingletonDoubleChecked() {
        wartoscSingleton = 9.98;
    }

    public static SingletonDoubleChecked getINSTANCE() {
        if (INSTANCE == null){
            synchronized (SingletonDoubleChecked.class){
                if (INSTANCE == null){
                    return new SingletonDoubleChecked();
                }
            }
        }
        return INSTANCE;
    }

    public double plusujZSingleton(int x){
        return x + this.wartoscSingleton;
    }
    public double plusujZSingleton(double x){
        return x + this.wartoscSingleton;
    }
    public double minusujZSingleton(int x){
        return x - this.wartoscSingleton;
    }
    public double minusujZSingleton(double x){
        return x - this.wartoscSingleton;
    }

}

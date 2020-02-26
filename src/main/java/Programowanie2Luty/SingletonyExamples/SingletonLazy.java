package Programowanie2Luty.SingletonyExamples;

public class SingletonLazy {
    private static SingletonLazy INSTANCE;
    private double wartoscSingleton;

    private SingletonLazy() {
        wartoscSingleton = 9.98;
    }

    public static SingletonLazy getINSTANCE() {
        if (INSTANCE == null){
            return new SingletonLazy();
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

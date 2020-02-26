package Programowanie2Luty.SingletonyExamples;



public enum SingletonEnumEager {
    INSTANCE(3.1645);

    public final double wartoscSingleton;

    SingletonEnumEager(final double wartoscSingleton) {
        this.wartoscSingleton = wartoscSingleton;
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

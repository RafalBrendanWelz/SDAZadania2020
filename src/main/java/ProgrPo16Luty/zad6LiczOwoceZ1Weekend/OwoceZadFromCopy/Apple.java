package ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy;

import java.util.Random;


public class Apple extends Owoc{

    public Apple(final double waga) {
        super( new Random().nextBoolean() ? ("Zielony") : ("Czerwony"), waga, "Jabłko");
    }




}

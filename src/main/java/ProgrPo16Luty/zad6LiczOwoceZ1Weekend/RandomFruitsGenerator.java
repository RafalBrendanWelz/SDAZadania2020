package ProgrPo16Luty.zad6LiczOwoceZ1Weekend;


import ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy.Apple;
import ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy.MagicalGrapefruit;
import ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy.Owoc;
import ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy.YelBanana;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomFruitsGenerator {
    private final int LIMIT_GENEROWANIA;
    private final int ILOSC_TYPOW_OWOCOW = 3;

    private static final int ZAMIEN_NA_KG = 1000;
    private static final int JABKO_MIN_GRAM = 250;
    private static final int MAG_GRAPEF_MIN_GRAM = 700;
    private static final int BANANA_MIN_GRAM = 300;

    public RandomFruitsGenerator(final int LIMIT_GENEROWANIA) {
        this.LIMIT_GENEROWANIA = LIMIT_GENEROWANIA;
    }

    public List<Owoc> generujALL(){
        return Stream.generate( this::giveRandomFruit )
                .limit(LIMIT_GENEROWANIA)
                .collect(Collectors.toList());
    }
    private Owoc giveRandomFruit(){
        Random losowanie = new Random();
        int typOwocu = losowanie.nextInt(ILOSC_TYPOW_OWOCOW);

        Owoc wynik;
        if (typOwocu == 0){
            wynik = giveApple();
        }else if (typOwocu == 1){
            wynik = giveMagicalGrapefruit();
        }else {
            wynik = giveBanana();
        }

        return wynik;
    }
    private Apple giveApple(){
        return new Apple( (double)((new Random().nextInt(1000)+JABKO_MIN_GRAM)/ ZAMIEN_NA_KG) );
    }
    private MagicalGrapefruit giveMagicalGrapefruit(){
        return new MagicalGrapefruit( (double)((new Random().nextInt(5000)+MAG_GRAPEF_MIN_GRAM)/ ZAMIEN_NA_KG), losujKolor() );
    }
    private YelBanana giveBanana(){
        return new YelBanana( (double)((new Random().nextInt(1100)+BANANA_MIN_GRAM)/ ZAMIEN_NA_KG) );
    }


    private String losujKolor(){
        switch (new Random().nextInt(5)){
            case 0:{
                return "Żółty";
            }case 1:{
                return "Różowy";
            }case 2:{
                return "Pomarańczowy";
            }case 3:{
                return "Niebieski";
            }case 4:{
                return "Zielony";
            } default:{
                return "Nieznany";
            }
        }
    }



}

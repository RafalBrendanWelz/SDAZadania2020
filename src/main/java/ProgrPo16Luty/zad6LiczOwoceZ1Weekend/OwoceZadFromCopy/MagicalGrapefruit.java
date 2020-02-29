package ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy;


public class MagicalGrapefruit extends Owoc{

    public MagicalGrapefruit(final double waga, final String kolor) {
        super( kolor, waga, "Magical Grape");
    }

    @Override
    public boolean getCzyPopsuty(){
        return false;
    }

}

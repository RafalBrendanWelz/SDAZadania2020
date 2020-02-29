package ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy;

import lombok.Getter;

import java.util.Random;

@Getter
public abstract class Owoc {

    private static final int BASE_SZANSA_ZEPS = 65;
    private boolean czyPopsuty;
    private String kolor;
    private double waga;
    private String nazwa;

    public Owoc( String kolor, double waga, String takaNazwa ){
        this.kolor = kolor;
        this.waga = waga;
        this.czyPopsuty = false;
        this.nazwa = takaNazwa;
    }

    public boolean getCzyPopsuty(){
        if (!this.czyPopsuty){
            this.czyPopsuty = losujCzyPopsuty();
            return this.czyPopsuty;
        }else {
            return this.czyPopsuty;
        }
    }

    private boolean losujCzyPopsuty (){
        Random losujacy = new Random();
        return losujacy.nextInt(100) > BASE_SZANSA_ZEPS;
    }

    @Override
    public String toString(){
        return this.getNazwa() + " koloru " + this.getKolor();
    }



}

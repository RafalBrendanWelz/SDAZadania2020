package Programowanie2Luty.zadsAutaZLuty902;

import lombok.Getter;

import java.util.Random;

@Getter
public abstract class AutoGeneryczne implements Car {
    boolean czyZepsSiln;
    String nazwaModelu;
    EngineType modelSiln;
    int iloscKoni;
    final int SZANS_ZE_NIE_POPSUJE_SIE;

    AutoGeneryczne(final String nazwaModelu, final EngineType modelSiln, final int iloscKoni, final int SZANS_ZE_NIE_POPSUJE_SIE) {
        this.nazwaModelu = nazwaModelu;
        this.modelSiln = modelSiln;
        this.iloscKoni = iloscKoni;
        this.SZANS_ZE_NIE_POPSUJE_SIE = SZANS_ZE_NIE_POPSUJE_SIE;
        this.czyZepsSiln = false;
    }

    @Override
    public String getModel(){
        return nazwaModelu;
    }
    @Override
    public int getHorsePower(){
        return iloscKoni;
    }
    @Override
    public EngineType getEngineType(){
        return modelSiln;
    }
    @Override
    public boolean czyZepsutySilnik(){
        return czyZepsSiln;
    }
    @Override
    public void setiChangeZepsutySiln(){
        czyZepsSiln = !czyZepsutySilnik();
    }

    @Override
    public void startEngine(){
        if (this.czyZepsSiln){
            System.out.println("Silnik jest zepsuty, nie pojedzie");
        }else {
            Random losujCzyPopsuje = new Random();
            if (losujCzyPopsuje.nextInt(100) > SZANS_ZE_NIE_POPSUJE_SIE){
                this.czyZepsSiln = true;
                System.out.println("Silnik się popsuł, ale jeszcze wystartował");
            }else {
                System.out.println("Udało się uruchomić silnik");
            }
        }
    }

}

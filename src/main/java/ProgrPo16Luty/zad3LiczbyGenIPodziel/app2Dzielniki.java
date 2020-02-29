package ProgrPo16Luty.zad3LiczbyGenIPodziel;


import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class app2Dzielniki {
    private int dzielnik1;
    private int dzielnik2;

    private app2Dzielniki(final int dzielnik1, final int dzielnik2) {
        this.dzielnik1 = dzielnik1;
        this.dzielnik2 = dzielnik2;
    }

    boolean isPodzielne(final int number, final whichDzielnikApp2Dzielniki chooseDzielnik){

        //synchronized (app2Dzielniki.this){
            switch (chooseDzielnik){
                case FIRST:{
                    return isPodzielneByFirst(number);
                }
                case SECOND:{
                    return isPodzielneBySecond(number);
                }
                default:{
                    System.out.println("Nieprawidłowo wybrany dzielnik: są tylko dwa");
                    return false;
                }
            }
        //}
    }

    boolean isPodzielneByFirst(final int number){
        return (number % this.dzielnik1 == 0);
    }

    boolean isPodzielneBySecond(final int number){
        return (number % this.dzielnik2 == 0);
    }


    static class appBuilder{
        private int dzielnik1;
        private int dzielnik2;

        appBuilder setDzielnik(final int danyDziel) {
            if (this.dzielnik1 == 0) {
                this.dzielnik1 = danyDziel;
            } else if (this.dzielnik2 == 0 && this.dzielnik1 != danyDziel) {
                this.dzielnik2 = danyDziel;
            } else if (this.dzielnik2 == 0 ) {
                System.out.println("Dwa dzielniki nie mogą być takie same.. Nie dodano drugiego dzielnika ");
            }
            return this;
        }

        appBuilder setDrugiDzielnik(final int danyDziel){
            return this.setDzielnik(danyDziel);
        }

        Optional<app2Dzielniki> build(){
            if (this.dzielnik1 != 0 && this.dzielnik2 != 0){
                return Optional.of(new app2Dzielniki(this.dzielnik1, this.dzielnik2));
            }else {
                return Optional.empty();
            }
        }
    }


}

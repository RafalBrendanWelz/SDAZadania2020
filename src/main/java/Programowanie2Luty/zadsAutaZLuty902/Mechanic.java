package Programowanie2Luty.zadsAutaZLuty902;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Mechanic {
    private String imie;
    private String nazwisko;


    public boolean tryFixCar(final Car toAuto){
        if ( toAuto.czyZepsutySilnik() ){
            Random sprobuje = new Random();
            if ( sprobuje.nextInt(100)>50 ){
                toAuto.setiChangeZepsutySiln();
                return true;
            }else {
                return false;
            }
        }else {
            return true;
        }
    }







}

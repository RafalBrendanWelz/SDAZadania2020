package Programowanie2Luty.zadsAutaZLuty902;

import java.util.Optional;

public class MainDlaAuta {

    public static void main(String[] args) {
        ToyotaCorolla pierwszeAudi = new ToyotaCorolla();

        System.out.println(pierwszeAudi.czyZepsSiln);
        System.out.println(pierwszeAudi.getIloscKoni());
        System.out.println(pierwszeAudi.getModelSiln());
        System.out.println(pierwszeAudi.getNazwaModelu());

        pierwszeAudi.startEngine();
        pierwszeAudi.startEngine();
        pierwszeAudi.startEngine();

        ParkingLot bestMiejsce = new ParkingLot();
        bestMiejsce.zaparkuj(pierwszeAudi);
        Optional<AutoGeneryczne> samochodZParkingu = bestMiejsce.wyparkuj();
        samochodZParkingu.ifPresent(autoGeneryczne -> System.out.println(autoGeneryczne.nazwaModelu));

        samochodZParkingu = bestMiejsce.wyparkuj();
        samochodZParkingu.ifPresent(autoGeneryczne -> System.out.println(autoGeneryczne.nazwaModelu));

    }



}

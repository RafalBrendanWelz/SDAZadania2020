package Programowanie2Luty.zadsAutaZLuty902;

import java.util.Optional;

public class MainDlaAuta {

    public static void main(String[] args) {
        ToyotaCorolla pierwszeAudi = new ToyotaCorolla();

        System.out.println(pierwszeAudi.czyZepsSiln);
        System.out.println(pierwszeAudi.getNazwaModelu());

        pierwszeAudi.startEngine();
        pierwszeAudi.startEngine();
        pierwszeAudi.startEngine();

        ParkingLot bestParking = new ParkingLot();
        bestParking.zaparkuj(pierwszeAudi);
        Optional<AutoGeneryczne> samochodZParkingu = bestParking.wyparkuj(pierwszeAudi);
        samochodZParkingu.ifPresent(autoGeneryczne -> System.out.println(autoGeneryczne.nazwaModelu));

        samochodZParkingu = bestParking.wyparkuj(pierwszeAudi);
        samochodZParkingu.ifPresent(autoGeneryczne -> System.out.println(autoGeneryczne.nazwaModelu));

    }



}

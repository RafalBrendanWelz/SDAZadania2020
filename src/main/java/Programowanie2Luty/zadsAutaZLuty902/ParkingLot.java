package Programowanie2Luty.zadsAutaZLuty902;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@NoArgsConstructor
public class  ParkingLot<T extends AutoGeneryczne> {
    private T zaparkowaneAuto;

    void zaparkuj(final T toAuto){
        if (this.zaparkowaneAuto == null){
            this.zaparkowaneAuto = toAuto;
        }else {
            System.out.println("Miejsce jest już zajęte");
        }
    }

    public Optional<T> getZaparkowaneAuto(){
        if (this.zaparkowaneAuto == null){
            System.out.println("Miejsce jest puste");
            return Optional.empty();
        }else {
            return Optional.of(this.zaparkowaneAuto);
        }
    }

    public void odholujNiesprawne(Mechanic obslugaParking){
        if (this.zaparkowaneAuto.czyZepsutySilnik()){

            if ( !obslugaParking.tryFixCar(this.zaparkowaneAuto) ) {
                wyparkuj();
            }
        }
    }

    Optional<T> wyparkuj(){
        if (this.zaparkowaneAuto == null){
            System.out.println("Miejsce jest puste");
            return Optional.empty();
        }else {
            Optional<T> autoWypark = Optional.of(this.zaparkowaneAuto);
            this.zaparkowaneAuto = null;
            return autoWypark;
        }
    }


}

package Programowanie2Luty.zadsAutaZLuty902;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class  ParkingLot<T extends AutoGeneryczne> {
    private List<T> parkedCars;

    void zaparkuj(final T toAuto){
        if (this.parkedCars == null){
            this.parkedCars = new ArrayList<>();
        }else {
           this.parkedCars.add(toAuto);
        }
    }

    public Optional<List<T>> getParkedCars(){
        if (this.parkedCars == null){
            System.out.println("Parking jest pusty");
            return Optional.empty();
        }else {
            return Optional.of(this.parkedCars);
        }
    }

    public void odholujNiesprawne(Mechanic obslugaParking){
        this.parkedCars.forEach( (auto) -> {

            if ( !obslugaParking.tryFixCar(auto) ) {
                wyparkuj(auto);
            }
        } );

    }

    Optional<T> wyparkuj(final T teAuto){
        if (this.parkedCars == null){
            System.out.println("Parking jest pusty");
            return Optional.empty();
        }else if ( this.parkedCars.contains(teAuto) ){
            Optional<T> autoWypark = Optional.of(teAuto);
            this.parkedCars.remove( teAuto );
            return autoWypark;
        }else {
            System.out.println("Na parkingu nie ma tego samochodu");
            return Optional.empty();
        }
    }


}

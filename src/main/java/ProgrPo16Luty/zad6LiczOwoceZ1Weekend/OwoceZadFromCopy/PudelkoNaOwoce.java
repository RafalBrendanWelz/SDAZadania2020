package ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PudelkoNaOwoce <T extends Owoc> {

    private List<T> owoce = new ArrayList<>();


    public void dodajOwoc( T takiOwoc ){
        owoce.add(takiOwoc);
    }

    public List<T> wyciagnijPopsute( ){
        this.owoce = this.owoce.stream()
                .filter( owc -> !owc.getCzyPopsuty() )
                .collect(Collectors.toList());

        return this.owoce.stream()
                .filter( Owoc::getCzyPopsuty )
                .collect(Collectors.toList());
    }

    public Double lacznaWaga(){
        return this.owoce.stream()
                .mapToDouble( Owoc::getWaga )
                .sum();
    }


}

package Programowanie2Luty.zadsZeZdaniaorazListaList;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OpracujZdaniePrzychodzace {

    private OpracujZdaniePrzychodzace() {
    }

    public static int iloscLiterWZdaniu( String zdanie){
        int wynik = 0;
        for (String znak: zdanie.split("")) {
            if ( znak.matches("[a-zA-Z]") ){
                wynik++;
            }
        }

        return wynik;
    }

    public static Map<String, Integer> dajIlosciWystapienSlow( String zdanie){
        Map<String, Integer> jakasMapa = new HashMap<>();

        Arrays.stream(zdanie.split(" "))
                .forEach( slowo -> jakasMapa.put( slowo, Arrays.stream(zdanie.split(" ")).mapToInt(jakies -> (jakies.equals(slowo)) ? (1) :(0)).sum() ));

        return jakasMapa;
    }

}

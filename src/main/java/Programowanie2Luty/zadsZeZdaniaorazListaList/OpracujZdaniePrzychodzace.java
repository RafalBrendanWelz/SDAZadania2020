package Programowanie2Luty.zadsZeZdaniaorazListaList;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class OpracujZdaniePrzychodzace {
    static OpracujZdaniePrzychodzace INSTANCE;

    private OpracujZdaniePrzychodzace() {
    }

    static OpracujZdaniePrzychodzace getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new OpracujZdaniePrzychodzace();
        }
        return INSTANCE;
    }

    int iloscLiterWZdaniu(final String zdanie){
        int wynik = 0;

        for (final char znak : zdanie.toCharArray()) {
            if (Character.isAlphabetic(znak)){
                wynik++;
            }
        }
        /*
        for (String znak: zdanie.split("")) {
            if ( znak.matches("[a-zA-Z]") ){
                wynik++;
            }
        }
        */
        return wynik;
    }

    Map<String, Integer> dajIlosciWystapienSlow(final String zdanie){
        final Map<String, Integer> jakasMapa = new HashMap<>();

        Arrays.stream(zdanie.split(" "))
                .forEach( slowo -> jakasMapa.put( slowo, Arrays.stream(zdanie.split(" ")).mapToInt(jakies -> (jakies.equals(slowo)) ? (1) :(0)).sum() ));

        return jakasMapa;
    }

}

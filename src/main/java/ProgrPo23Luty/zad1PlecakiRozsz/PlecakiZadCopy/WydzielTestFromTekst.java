package ProgrPo23Luty.zad1PlecakiRozsz.PlecakiZadCopy;


import java.util.List;
import java.util.stream.Collectors;

public class WydzielTestFromTekst {
    private static final int MIEJSCE_NAZWY_TEST = 0;
    private static final int MIEJSCE_CZASU_TEST = 1;
    private static final int SPODZ_DLUG_SPLITA = 2;

    public List<OpisTest> dajTestyZTekstow (final List<String> opisyTest, final String znak_Podzialu){

        return opisyTest.stream()
                .map( opis -> opis.split(znak_Podzialu) )
                .filter( arraStri -> arraStri.length == SPODZ_DLUG_SPLITA )
                .map( arraStri -> new OpisTest(arraStri[MIEJSCE_NAZWY_TEST], Long.parseLong(arraStri[MIEJSCE_CZASU_TEST]) ))
                .collect(Collectors.toList());
              //                                              //tutaj możliwy wyjątek bo nie ma upewnienia czy parseLong na pewno ma tylko long tekst

    }


}

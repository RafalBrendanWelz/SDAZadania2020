package ProgrPo23Luty.zad1PlecakiRozsz.PlecakiZadCopy;


import WlasneWyjatk.WlasnyIOExcept;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerwisPrzydzialuDoPlecak {
    private final int ILOSC_PLECAK;

    public SerwisPrzydzialuDoPlecak(final int ILOSC_PLECAK) {
        this.ILOSC_PLECAK = ILOSC_PLECAK;
    }


    public List<Plecak> podzielTestdoPlecakow(final List<OpisTest> allTesty){   //mozna na streamach
        List<Plecak> wynik = dajPustePlecaki();

        IlePlecakValidate();

        for (OpisTest pojedTest: allTesty) {
            processDajTestDoPlecak(pojedTest, wynik);
        }

        return wynik;
    }
    private void IlePlecakValidate(){
        if (ILOSC_PLECAK <= 0){
            throw new WlasnyIOExcept("Nie może być 0 ani < 0 plecaków");
        }
    }
    private int dajLightestPlecakIndex(final List<Plecak> tychPlecakow){

            return tychPlecakow.stream()
                    .collect(Collectors.toMap(ple -> tychPlecakow.indexOf(ple), ple -> ple.dajSumeCzasow()))
                    .entrySet()
                    .stream().min(new Comparator<Map.Entry<Integer, Long>>() {
                        @Override
                        public int compare(final Map.Entry<Integer, Long> o1, final Map.Entry<Integer, Long> o2) {
                            return Long.compare(o1.getValue(), o2.getValue());
                        }
                    }).map( Map.Entry::getKey )
                    .orElseThrow();             //szybka metoda zwraca wartość optionala jeśli jest, jak nie to wyrzuca error
    }
    private List<Plecak> dajPustePlecaki( ){

        return Stream.generate( () -> new Plecak(new ArrayList<>()) ).limit(ILOSC_PLECAK)
                .collect(Collectors.toList());
    }
    private void processDajTestDoPlecak(final OpisTest tenTest, final List<Plecak> zTychPlecak){
        int MinimalIndex = dajLightestPlecakIndex(zTychPlecak);

        zTychPlecak.get(MinimalIndex).dolozTest(tenTest);
    }



}

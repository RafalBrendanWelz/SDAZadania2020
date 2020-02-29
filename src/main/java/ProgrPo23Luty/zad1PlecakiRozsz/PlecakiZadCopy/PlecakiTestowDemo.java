package ProgrPo23Luty.zad1PlecakiRozsz.PlecakiZadCopy;

import java.util.List;

public class PlecakiTestowDemo {

    public static void main(String[] args) {
        final String sciezkaKatalog = args[0];

        final zczytaczTestowZPliku czytaj = new zczytaczTestowZPliku();
        final WydzielTestFromTekst dawajTesty = new WydzielTestFromTekst();
        final SerwisPrzydzialuDoPlecak poprzydzielaj = new SerwisPrzydzialuDoPlecak( Integer.parseInt(args[1]) );
        final zapisDoPlikow zapisuj = new zapisDoPlikow();

        final String znakPodzialu = ":";
        final String miejsceDaneWejsc =
           "C:\\Dysk_Brendan\\_CodingTools\\IntelliJ\\IntelliJ IDEA workplace\\ProgramowanieIIStreams\\src\\main\\resources\\Luty23Files\\daneWejscTestow\\allTesty";


        List<String> opisyTestow = czytaj.zczytDanychAllTest(miejsceDaneWejsc);
        System.out.println(opisyTestow);

        List<OpisTest> wszystkieTesty = dawajTesty.dajTestyZTekstow(opisyTestow, znakPodzialu );
        System.out.println(wszystkieTesty.size());

        List<Plecak> dawajPlecaki = poprzydzielaj.podzielTestdoPlecakow(wszystkieTesty);
        System.out.println(dawajPlecaki.size());

        zapisuj.zapisujDoPlikow( dawajPlecaki, sciezkaKatalog );

    }



}

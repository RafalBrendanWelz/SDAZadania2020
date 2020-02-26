package Programowanie2Luty.zadsMedaleKraje;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class MedalDataWriter {

    private MedalDataWriter() {
    }

    public static void zapiszALLstatsMedaliKrajiDoPlik(String sciezkaDoPlik, List<ZbiorMedaliKraju> ListaMKDoStats ) throws IOException {
        Path sciezka = Path.of(sciezkaDoPlik);

        Map<String, List<String>> statystyka = dajStatystyke(ListaMKDoStats); //key - typ statystyki, value - lista wartosci danej statystyki

        Files.writeString( sciezka, "Statystyka Danych o Krajach i zdobytych przez nich medali \n\n" );
        for (final String pozycjaDoZapisu : statystyka.keySet()) {
            Files.writeString( sciezka, pozycjaDoZapisu + statystyka.get(pozycjaDoZapisu) + "\n", StandardOpenOption.APPEND);
        }

    }

    private static Map<String, List<String>> dajStatystyke ( List<ZbiorMedaliKraju> zbior ){
        Map<String, List<String>> statystyka = new LinkedHashMap<>(); //key - typ statystyki, value - lista wartosci danej statystyki
        statystyka.put( "Państwa z minimum 1 złotym medalem:\n   ", List.of(KrajMedalFinder.znajdzPanstwaZmin1Zloty(zbior).stream().collect(Collectors.joining(","))) );
        statystyka.put( "Państwa z minimum 1 jakimkolwiek medalem:\n   ", List.of(KrajMedalFinder.znajdzPanstwaZmin1Jakikolwiek(zbior).stream().collect(Collectors.joining(","))) );
        statystyka.put( "Państwa z większą ilością Srebrnych niż złotych:\n   ", List.of(KrajMedalFinder.wyszukKrajeGdzieWiecejSrebrNizZlot(zbior).stream().collect(Collectors.joining(","))) );
        statystyka.put( " ", Collections.emptyList());
        statystyka.put( "Sumy Państwo-Ilość medali: ", List.of(" (Kraj-Medale) ") );

        Map<String, Integer> sumyKrajMedale = KrajMedalFinder.dajStatsSumyKrajIleMedali(zbior);
        List<String> jednaLiniaWartosciZSumyKrajMedale = new LinkedList<>();
        int licznik = -1;
        int byZmienicLinie = sumyKrajMedale.get( sumyKrajMedale.keySet().iterator().next() );
        for (final String kraj : sumyKrajMedale.keySet()) {
            ++licznik;
            if ( sumyKrajMedale.get(kraj) != byZmienicLinie ){
                statystyka.put( licznik + "   ", jednaLiniaWartosciZSumyKrajMedale );
                jednaLiniaWartosciZSumyKrajMedale = new LinkedList<>();
            }
            byZmienicLinie = sumyKrajMedale.get(kraj);
            jednaLiniaWartosciZSumyKrajMedale.add( kraj + " - " + sumyKrajMedale.get(kraj) + " medali");
        }
        statystyka.put( licznik+1 + "   ", jednaLiniaWartosciZSumyKrajMedale );
        statystyka.put( " ", Collections.emptyList() );
        statystyka.put( " Dominantą spośród ilości zdobytych złotych medali jest: ", List.of( String.valueOf(KrajMedalFinder.znajdzDominanteSposrodIlosciZlotychMedali(zbior)) ) );
        statystyka.put( " Krajem o największej liczbie punktów ( G=3, S=2, B=1 ) jest: ", List.of( KrajMedalFinder.znajdzKrajZMaxOgolnyWynik(zbior) ) );
        statystyka.put( " Wszystkich Medali łącznie jest: ", List.of( String.valueOf(KrajMedalFinder.sumujALLMedale(zbior))) );
        statystyka.put( " Kraje posortowane malejąco według ilości uzyskanych srebrnych medali:\n   ", KrajMedalFinder.posortujJeWedlugSrebrnych(zbior).stream().map(ZbiorMedaliKraju::getNazwaKraju).collect(Collectors.toList()) );

        return statystyka;
    }


}

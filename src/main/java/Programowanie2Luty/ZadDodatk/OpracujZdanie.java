package Programowanie2Luty.ZadDodatk;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class OpracujZdanie {

    private OpracujZdanie() {
    }

    public static int dajIloscLiterWzdaniu( String zdanie ){
        int wynik = 0;
        String[] litery = zdanie.split("");

        for (int i = 0; i < litery.length; i++) {
            if (litery[i].matches( "[a-zA-ząśęółćźżńĄĆĘŁŃÓŚŹŻ]" )) {
                wynik++;
            }
        }

        return wynik;
    }

    public static String powiedzIleMalychaIleDuzych(String zdanie){
        int male = 0;
        int duze = 0;
        String[] litery = zdanie.split("");

        for (int i = 0; i < litery.length; i++) {
            if (litery[i].matches( "[a-ząśęółćźżń]" )) {
                male++;
            }else if (litery[i].matches( "[A-ZĄĆĘŁŃÓŚŹŻ]" )){
                duze++;
            }
        }

        return "Małych liter użyto: " + male + "\n" + "Dużych liter użyto: " + duze;
    }
    public static String medianaCiaguDlugosciWyrazow(String tegoZdania){
        String[] litery = tegoZdania.split("");

        StringBuilder podzialWyrazow = new StringBuilder();
        List<String> wyrazy = new LinkedList<>();
        /*for (int i = 0; i < litery.length; i++) {
            if (litery[i].matches("[a-zA-ZąśęółćźżńĄĆĘŁŃÓŚŹŻ]")){
                podzialWyrazow.append(litery[i]);
            }else {
                wyrazy.add(podzialWyrazow.toString());
                podzialWyrazow.delete(0, podzialWyrazow.length());
            }
        }*/ //to samo co poniżej przez stream tylko innym sposobem

        Arrays.stream(litery)
                .forEach( lit -> {
                    if (lit.matches("[a-zA-ZąśęółćźżńĄĆĘŁŃÓŚŹŻ]")) {
                        podzialWyrazow.append(lit);
                    } else {
                        wyrazy.add(podzialWyrazow.toString());
                        podzialWyrazow.delete(0, podzialWyrazow.length()) ;
                    }
                } );
        wyrazy.add(podzialWyrazow.toString());

        List<String> sprawdzenie = wyrazy.stream()
                .filter( wyr -> wyr.length()!=0 )
                .map( String::toLowerCase )
                .distinct()
                .collect(Collectors.toList());

        List<Integer> wynik = wyrazy.stream()
                .filter( wyr -> wyr.length()!=0 )
                .map( String::toLowerCase )
                .distinct()
                .map( String::length )
                .collect(Collectors.toList());


        return " środkowy wyraz zdania = " + sprawdzenie.get(sprawdzenie.size()/2) + " jego długośc = " + wynik.get(wynik.size()/2);
    }


    public static String znajdz1PowtarzajacaSieLitere(String tekst){
        String slowo = tekst.trim().split(" ")[0];

        String wynik = "Brak powtorzen";
        for (int i = 0; i < slowo.length(); i++) {
            wynik = czyPowtarza(slowo.charAt(i), slowo, i+1);
            if (wynik.length() == 1 ){
                break;
            }
        }

        return wynik;
    }
    private static String czyPowtarza( char litera, String slowo, int sprawdzaneMiejsc ){
        if (sprawdzaneMiejsc == slowo.length()){
            return "Brak powtorzen";
        }else {
            return ( litera == slowo.charAt(sprawdzaneMiejsc) ) ? (String.valueOf(litera)) : (czyPowtarza(litera, slowo, ++sprawdzaneMiejsc) ) ;
        }
    }


}

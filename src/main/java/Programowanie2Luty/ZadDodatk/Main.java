package Programowanie2Luty.ZadDodatk;

import Programowanie2Luty.zadsZeZdaniaorazListaList.OpracujListeObiekt;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(OpracujZdanie.medianaCiaguDlugosciWyrazow("ala,DÓĘRć mąka kota łódź. Ala Ma Trzy Koty, a te koty to nie moje-Masakracja kota kota"));

        Long dominanta = OpracujListeObiekt.dajDominanteZListyLong(List.of(List.of(11L, 16L, 13L), List.of(1324L, 9L, 13L), List.of(13L, 13L, 12L, 12L), List.of(13L, 590L, 12L, 9L)  ));
        System.out.println(dominanta);

        double sredniaDl = sredniaDlSlowaZtychList(List.of( List.of("dea", "dwa2d", "dwa.dwa"), List.of("ala", "sra[]la") ));
        System.out.println(sredniaDl);
    }

    public static Double sredniaDlSlowaZtychList(List<List<String>> listaListString ){

        List<Integer> dlugosci = listaListString.stream()
                .flatMap( Collection::stream )
                .filter( sl -> sl.length()!=0 )
                .map(new Function<String, String>() {
                    @Override
                    public String apply(final String s) {
                        StringBuilder stworzWyraz = new StringBuilder();
                        String[] litery = s.split("");

                        for (String lit: litery) {
                            if (lit.matches("[a-zA-Z]")){
                                stworzWyraz.append(lit);
                            }
                        }

                        return  s.replaceAll("\\W","");
                    }
                })
                .map( String::length )
                .collect(Collectors.toList());

        return (double) dlugosci.stream().mapToInt(dl -> dl).sum() / (double) dlugosci.size();
    }



}

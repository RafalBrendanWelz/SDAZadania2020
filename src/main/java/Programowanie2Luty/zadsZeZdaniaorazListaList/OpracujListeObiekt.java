package Programowanie2Luty.zadsZeZdaniaorazListaList;

import java.util.*;
import java.util.stream.Collectors;

public class OpracujListeObiekt {

    private OpracujListeObiekt() {
    }



    public static Long dajDominanteZListyLong( List<List<Long>> listaListLiczb){
         Map<Long, List<Long>> wynik = listaListLiczb.stream()
                .flatMap( Collection::stream )
                .collect(Collectors.groupingBy( liczba -> liczba ));

        System.out.println(wynik);

        return wynik.entrySet().stream()
                 .sorted(new Comparator<Map.Entry<Long, List<Long>>>() {
                     @Override
                     public int compare(final Map.Entry<Long, List<Long>> o1, final Map.Entry<Long, List<Long>> o2) {
                         int wystO1 = o1.getValue().size();
                         int wystO2 = o2.getValue().size();

                         return Integer.compare(wystO1, wystO2)*-1;
                     }
                 }).collect(Collectors.toList()).get(0).getKey();

    }

    public static double dajSredniaDlugoscSlowa( List<List<String>> zbioryListSlow){
        String calosc = zbioryListSlow.stream().flatMap( Collection::stream ).collect(Collectors.joining(" "));

        return (double)Arrays.stream(calosc.split(" "))
                .mapToInt( String::length )
                .sum() / (double)calosc.split(" ").length ;
    }

}

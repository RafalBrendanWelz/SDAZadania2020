package Programowanie2Luty.zadsZeZdaniaorazListaList;

import java.util.*;
import java.util.stream.Collectors;

class OpracujListeObiekt {
    static OpracujListeObiekt INSTANCE;

    private OpracujListeObiekt() {
    }

    static OpracujListeObiekt getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new OpracujListeObiekt();
        }
        return INSTANCE;
    }

    Long dajDominanteZListyLong(final List<List<Long>> listaListLiczb){
         final Map<Long, List<Long>> wynik = listaListLiczb.stream()
                .flatMap( Collection::stream )
                .collect(Collectors.groupingBy( liczba -> liczba ));


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

    double dajSredniaDlugoscSlowa(final List<List<String>> zbioryListSlow){
        final String calosc = zbioryListSlow.stream().flatMap( Collection::stream ).collect(Collectors.joining(" "));

        return Arrays.stream(calosc.split(" "))
                .mapToDouble( String::length )
                .sum() / calosc.split(" ").length ;
    }

}

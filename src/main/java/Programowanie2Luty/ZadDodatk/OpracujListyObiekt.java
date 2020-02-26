package Programowanie2Luty.ZadDodatk;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OpracujListyObiekt {


    public static Long dajDominantZLong (List<List<Long>> listaLong){

        Map<Long, Integer> mapaWystapien = listaLong.stream()
                .flatMap( Collection::stream )
                .collect(Collectors.groupingBy( liczb -> liczb ) )
                    .entrySet().stream()
                            .sorted(new Comparator<Map.Entry<Long, List<Long>>>() {
                                @Override
                                public int compare(final Map.Entry<Long, List<Long>> o1, final Map.Entry<Long, List<Long>> o2) {
                                    int powtorzeniaO1 = o1.getValue().size();
                                    int powtorzeniaO2 = o2.getValue().size();

                                    return Integer.compare(powtorzeniaO1, powtorzeniaO2)*-1;
                                }
                            }).collect(Collectors.toMap( Map.Entry::getKey , poz -> poz.getValue().size()) );

        System.out.println(mapaWystapien);

        return mapaWystapien.entrySet().iterator().next().getKey();
    }


}

package ProgrPo16Luty;

import java.util.HashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SzybkieStrzalySprawdzanie {


    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(0, 10) + "\n");

        final int[] i = {0};    //sposób na użycie stream generate z zmienną finalną (bo taka musi być w wewnętrznej klasie lub lambdzie oraz z trikiem na jednowartościową tablicą
        System.out.println(Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return ++i[0];
            }
        }).limit(5).collect(Collectors.toList()) );




    }

    private static void schowekTest(){
        Stream.empty();

        HashMap<String, Integer> costam = new HashMap<>();
        costam.entrySet().stream();



    }




}

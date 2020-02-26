package Programowanie2Luty.zadsZeZdaniaorazListaList;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(OpracujZdaniePrzychodzace.iloscLiterWZdaniu("wd123aa dsad"));

        System.out.println(OpracujZdaniePrzychodzace.dajIlosciWystapienSlow("wd123aa dsad ala ma kota ala"));

        System.out.println(   OpracujListeObiekt.dajDominanteZListyLong(List.of(List.of(1L, 2L, 3L, 45L, 3L), List.of(1L, 256L)))  );

        System.out.println(  OpracujListeObiekt.dajSredniaDlugoscSlowa( List.of( List.of("wa dwa wda") , List.of("dwa", "pororo") ))  );

    }




}

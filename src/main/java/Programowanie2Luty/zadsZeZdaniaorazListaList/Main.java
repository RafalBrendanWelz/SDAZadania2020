package Programowanie2Luty.zadsZeZdaniaorazListaList;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(OpracujZdaniePrzychodzace.getINSTANCE().iloscLiterWZdaniu("wd123aa dsad"));

        System.out.println(OpracujZdaniePrzychodzace.getINSTANCE().dajIlosciWystapienSlow("wd123aa dsad ala ma kota ala"));

        System.out.println(   OpracujListeObiekt.getINSTANCE().dajDominanteZListyLong(List.of(List.of(1L, 2L, 3L, 45L, 3L), List.of(1L, 256L)))  );

        System.out.println(  OpracujListeObiekt.getINSTANCE().dajSredniaDlugoscSlowa( List.of( List.of("wa dwa wda") , List.of("dwa", "pororo") ))  );

    }




}

package ProgrPo23Luty.zad1PlecakiRozsz.PlecakiZadCopy;


import WlasneWyjatk.WlasnyIOExcept;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class zczytaczTestowZPliku {

    public List<String> zczytDanychAllTest(final String sciezka){
        List<String> wszystkieDaneTest = new LinkedList<>();

        try(FileReader zczytacz = new FileReader(sciezka)){
            BufferedReader czytajacy = new BufferedReader(zczytacz);
            czytajacy.lines().forEach( wszystkieDaneTest::add );

        }catch (IOException e){
            throw new WlasnyIOExcept("Nie mozna odczytac pliku");
        }

        return wszystkieDaneTest;
    }





}

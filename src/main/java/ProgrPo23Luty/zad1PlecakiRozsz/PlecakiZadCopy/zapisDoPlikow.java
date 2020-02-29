package ProgrPo23Luty.zad1PlecakiRozsz.PlecakiZadCopy;

import pl.sdacademy.prog.o8o9Luty.Streams0802.WlasneWyjatk.WlasnyIOExcept;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class zapisDoPlikow {

    public void zapisujDoPlikow(final List<Plecak> plecaki, final String sciezkaKatalogu){

        plecaki.forEach( plecak -> zapiszJedenPlecak(plecak, sciezkaKatalogu, plecaki.indexOf(plecak) ));
    }
    private List<String> dajOpisyTestow (final Plecak zTegoPlecaka){
        return zTegoPlecaka.getTesty().stream()
                .map( testu -> testu.getNazwa()+":"+testu.getCzasMilisek() )
                .collect(Collectors.toList());
    }
    private void zapiszJedenPlecak( final Plecak tenPlecak, final String sciezkaKatalogu, final int index ){
        Path sciezka = Path.of(sciezkaKatalogu+"\\plecak"+index+".txt");
        try {
            Files.write( sciezka , dajOpisyTestow(tenPlecak), StandardOpenOption.CREATE );
            String lacznyCzas = "\nLaczny czas="+tenPlecak.dajSumeCzasow();
            Files.write( sciezka , lacznyCzas.getBytes() , StandardOpenOption.APPEND );
        } catch (IOException e) {
            throw new WlasnyIOExcept("Nie udało się zapisać do pliku");
        }
    }




}

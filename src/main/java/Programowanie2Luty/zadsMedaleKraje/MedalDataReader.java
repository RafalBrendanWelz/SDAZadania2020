package Programowanie2Luty.zadsMedaleKraje;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MedalDataReader {

    MedalDataReader() {
    }

    List<ZbiorMedaliKraju> zczytajMedaleZPliku(String sciezkaDoPliku) throws IOException {
        Path sciezka = Path.of(sciezkaDoPliku);

        return Files.readAllLines(sciezka).stream()
                .filter( ln -> ln.length()!=0 )
                .map( linia -> linia.split(",") )
                .map( this::mapStringArrayToMedaleZbior )
                .collect(Collectors.toList());
    }
    private ZbiorMedaliKraju mapStringArrayToMedaleZbior(final String[] arrayToMap ){
        if (arrayToMap.length == 5){
            return new ZbiorMedaliKraju( arrayToMap[0], Integer.parseInt(arrayToMap[1]), Integer.parseInt(arrayToMap[2]), Integer.parseInt(arrayToMap[3]), Integer.parseInt(arrayToMap[4]) );
        }else {
            return new ZbiorMedaliKraju( arrayToMap[0], Integer.parseInt(arrayToMap[1]), Integer.parseInt(arrayToMap[2]), Integer.parseInt(arrayToMap[3]) );
        }
    }





}

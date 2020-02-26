package Programowanie2Luty.zadsMedaleKraje;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class MedalDataReader {

    private MedalDataReader() {
    }

    public static List<ZbiorMedaliKraju> zczytajMedaleZPliku(String sciezkaDoPliku ) throws IOException {
        Path sciezka = Path.of(sciezkaDoPliku);

        return Files.readAllLines(sciezka).stream()
                .filter( ln -> ln.length()!=0 )
                .map( linia -> linia.split(",") )
                .map( tablWyr -> (tablWyr.length == 5 ) ?
                        ( new ZbiorMedaliKraju( tablWyr[0], Integer.parseInt(tablWyr[1]), Integer.parseInt(tablWyr[2]), Integer.parseInt(tablWyr[3]), Integer.parseInt(tablWyr[4]) ) )
                        : ( new ZbiorMedaliKraju( tablWyr[0], Integer.parseInt(tablWyr[1]), Integer.parseInt(tablWyr[2]), Integer.parseInt(tablWyr[3]) ) ))
                .collect(Collectors.toList());
    }





}

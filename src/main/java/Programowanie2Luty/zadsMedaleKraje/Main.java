package Programowanie2Luty.zadsMedaleKraje;


import java.io.IOException;
import java.util.List;

public class Main {
    private static final String SCIEZDODATA4 = "C:\\Dysk_Brendan\\_CodingTools\\IntelliJ\\IntelliJ IDEA workplace\\SDAZadania2020\\data4.txt";
    private static final String SCIEZDOZAPIS = "C:\\Dysk_Brendan\\_CodingTools\\IntelliJ\\IntelliJ IDEA workplace\\SDAZadania2020\\zapisStatsMedali.txt";

    public static void main(String[] args) throws IOException {
        MedalDataReader medaleReader = new MedalDataReader();
        List<ZbiorMedaliKraju> medaleAll = medaleReader.zczytajMedaleZPliku(SCIEZDODATA4);

        zapisujDoPlik(medaleAll);

        wypisywanieRoznychZnalezienDlaPaczeniaJakSieZnajduja(medaleAll);
    }

    private static void zapisujDoPlik(final List<ZbiorMedaliKraju> teMedaleKraje ) throws IOException {
        MedalDataWriter medaleWriter = new MedalDataWriter();

        medaleWriter.zapiszALLstatsMedaliKrajiDoPlik( SCIEZDOZAPIS, teMedaleKraje );
    }

    private static void wypisywanieRoznychZnalezienDlaPaczeniaJakSieZnajduja (final List<ZbiorMedaliKraju> naTePaczymy ){
        System.out.println("\n  Najwięcej Medali Złotych ma: " + KrajMedalFinder.znajdzPanstwoZMaxZlotych(naTePaczymy));
        System.out.println("  Najwięcej Medali łącznie ma: " + KrajMedalFinder.znajdzKrajzMaxAllMedali(naTePaczymy));
        System.out.println("  Najwięcej Medali za 4 miejsce ma: " + KrajMedalFinder.znajdzPanstwoZMax4MiejscMedali(naTePaczymy) + "\n");

        System.out.println("  Dominantą Złotych Medali jest: " + KrajMedalFinder.znajdzDominanteSposrodIlosciZlotychMedali(naTePaczymy) + "\n");
        System.out.println("  Kraj z największą punktacją to: " + KrajMedalFinder.znajdzKrajZMaxOgolnyWynik(naTePaczymy) );
        System.out.println("  Wszystkich rozdanych medali jest: " + KrajMedalFinder.sumujALLMedale(naTePaczymy) );
    }







}

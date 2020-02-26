package Programowanie2Luty.zadsMedaleKraje;


import java.util.*;
import java.util.stream.Collectors;

public class KrajMedalFinder {

    private KrajMedalFinder() {
    }

    public static List<String> znajdzPanstwaZmin1Zloty(List<ZbiorMedaliKraju> medaleKrajow){
        return medaleKrajow.stream()
                .filter( medKra -> medKra.getIloscGOLDmedal() >=1 )
                .map( ZbiorMedaliKraju::getNazwaKraju )
                .collect(Collectors.toList());
    }

    public static List<String> znajdzPanstwaZmin1Jakikolwiek(List<ZbiorMedaliKraju> medaleKrajow){
        return medaleKrajow.stream()
                .filter( medKra -> medKra.getIloscGOLDmedal() >=1 || medKra.getIloscBRONZEmedal() >=1 || medKra.getIloscSilvermedal() >=1 || medKra.getIlosc4medal()>=1 )
                .map( ZbiorMedaliKraju::getNazwaKraju )
                .collect(Collectors.toList());
    }

    public static String znajdzPanstwoZMaxZlotych(List<ZbiorMedaliKraju> medaleKrajow){
        TreeMap<Integer, String > krajePlusIleZlotych = new TreeMap<>();

        for (final ZbiorMedaliKraju kraj : medaleKrajow) {
            krajePlusIleZlotych.put( kraj.getIloscGOLDmedal(), kraj.getNazwaKraju() );
        }

        List<String> wynik = new ArrayList<>(krajePlusIleZlotych.values());
        return wynik.get(wynik.size()-1);
    }
    public static String znajdzKrajzMaxAllMedali(List<ZbiorMedaliKraju> medaleKrajow){
        TreeMap<Integer, String > krajePlusIleZlotych = new TreeMap<>();

        medaleKrajow.stream()
                .forEach( kraj -> {
                    int sumaMedali = kraj.getIloscGOLDmedal() + kraj.getIlosc4medal() + kraj.getIloscSilvermedal() + kraj.getIloscBRONZEmedal();
                    krajePlusIleZlotych.put(sumaMedali, kraj.getNazwaKraju());
                } );

        List<String> wynik = new ArrayList<>(krajePlusIleZlotych.values());
        return wynik.get(wynik.size()-1);
    }
    public static String znajdzPanstwoZMax4MiejscMedali(List<ZbiorMedaliKraju> medaleKrajow){
        return medaleKrajow.stream()
                .sorted(new Comparator<ZbiorMedaliKraju>() {
                    @Override
                    public int compare(final ZbiorMedaliKraju o1, final ZbiorMedaliKraju o2) {
                        int ile4miejsco1 = o1.getIlosc4medal();
                        int ile4miejsco2 = o2.getIlosc4medal();

                        return Integer.compare(ile4miejsco1, ile4miejsco2)*-1;
                    }
                }).collect(Collectors.toList()).get(0).getNazwaKraju();


        /*  //to stary sposób zanim rozkminiłem wstawnianie własnych komparatorów, też działa
        TreeMap<Integer, String > krajePlusIleZlotych = new TreeMap<>();

        for (final ZbiorMedaliKraju kraj : medaleKrajow) {
            krajePlusIleZlotych.put( kraj.getIlosc4medal(), kraj.getNazwaKraju() );
        }

        List<String> wynik = new ArrayList<>(krajePlusIleZlotych.values());
        return wynik.get(wynik.size()-1);
        */
    }

    public static List<String> wyszukKrajeGdzieWiecejSrebrNizZlot(List<ZbiorMedaliKraju> medaleKrajow){
        return medaleKrajow.stream()
                .filter( kraj -> kraj.getIloscSilvermedal() > kraj.getIloscGOLDmedal() )
                .map( ZbiorMedaliKraju::getNazwaKraju )
                .collect(Collectors.toList());
    }

    public static List<String> wyszukKrajeGdzieBronzSrebrZloto(List<ZbiorMedaliKraju> medaleKrajow){
        return medaleKrajow.stream()
                .filter( kraj -> kraj.getIloscBRONZEmedal() > kraj.getIloscSilvermedal() && kraj.getIloscSilvermedal() > kraj.getIloscGOLDmedal() )
                .map( ZbiorMedaliKraju::getNazwaKraju )
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> dajStatsSumyKrajIleMedali(List<ZbiorMedaliKraju> medaleKrajow ){
        Map<String, Integer> wynik = new LinkedHashMap<>();

        medaleKrajow.stream()
                .sorted(new Comparator<ZbiorMedaliKraju>() {
                    @Override
                    public int compare(final ZbiorMedaliKraju o1, final ZbiorMedaliKraju o2) {
                        int sumaMedalo1 = o1.getIloscGOLDmedal() + o1.getIloscSilvermedal() + o1.getIloscBRONZEmedal();
                        int sumaMedalo2 = o2.getIloscGOLDmedal() + o2.getIloscSilvermedal() + o2.getIloscBRONZEmedal();

                        return Integer.compare(sumaMedalo1, sumaMedalo2)*-1;
                    }
                }).forEach( kraj -> {
                    wynik.put(kraj.getNazwaKraju(), kraj.getIloscGOLDmedal() + kraj.getIloscSilvermedal() + kraj.getIloscBRONZEmedal());
        } );

        return wynik;
    }

    public static int znajdzDominanteSposrodIlosciZlotychMedali(List<ZbiorMedaliKraju> medaleKrajow){
        Map<Integer, Integer> wynik = new TreeMap<>();

         List<Integer> ileZloto = medaleKrajow.stream()
                .map( ZbiorMedaliKraju::getIloscGOLDmedal )
                .collect(Collectors.toList()  );

         List<Integer> czestoscci = ileZloto.stream()
                 .map( liczba -> sumujWystapienia( ileZloto, liczba ) )
                 .collect(Collectors.toList());

        for (int i = 0; i < ileZloto.size(); i++) {
            wynik.put( czestoscci.get(i), ileZloto.get(i) );
        }

        return new ArrayList<>(wynik.values()).get(wynik.values().size()-1);
    }
    private static int sumujWystapienia(List<Integer> wsrodTych, Integer taLiczba){
        int wynik = 0;

        for (final Integer liczba : wsrodTych) {
            if ( liczba.equals(taLiczba) ){
                wynik++;
            }
        }

        return wynik;
    }

    public static String znajdzKrajZMaxOgolnyWynik (List<ZbiorMedaliKraju> MedaleKrajow){
        return MedaleKrajow.stream().sorted(new Comparator<ZbiorMedaliKraju>() {
            @Override
            public int compare(final ZbiorMedaliKraju o1, final ZbiorMedaliKraju o2) {
                int punktyO1 = (o1.getIloscGOLDmedal() * 3) + (o1.getIloscSilvermedal() * 2) + o1.getIloscBRONZEmedal();
                int punktyO2 = (o2.getIloscGOLDmedal() * 3) + (o2.getIloscSilvermedal() * 2) + o2.getIloscBRONZEmedal();

                return Integer.compare(punktyO1, punktyO2)*-1;
            }
        }).collect(Collectors.toList()).get(0).getNazwaKraju();
    }

    public static int sumujALLMedale(List<ZbiorMedaliKraju> MedaleKrajow){
        return MedaleKrajow.stream()
                .mapToInt( kraj -> kraj.getIloscBRONZEmedal() + kraj.getIloscSilvermedal() + kraj.getIloscGOLDmedal() )
                .sum();
    }

    public static List<ZbiorMedaliKraju> posortujJeWedlugSrebrnych(List<ZbiorMedaliKraju> jeDoSortu){
        return jeDoSortu.stream()
                .sorted(new Comparator<ZbiorMedaliKraju>() {
                    @Override
                    public int compare(final ZbiorMedaliKraju o1, final ZbiorMedaliKraju o2) {
                        int ileSrebro1 = o1.getIloscSilvermedal();
                        int ileSrebro2 = o2.getIloscSilvermedal();

                        return Integer.compare(ileSrebro1, ileSrebro2)*-1;
                    }
                }).collect(Collectors.toList());
    }




}

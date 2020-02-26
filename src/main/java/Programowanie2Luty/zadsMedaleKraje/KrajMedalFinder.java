package Programowanie2Luty.zadsMedaleKraje;


import java.util.*;
import java.util.stream.Collectors;

public class KrajMedalFinder {

    private KrajMedalFinder() {
    }

    static List<String> znajdzPanstwaZmin1Zloty(final List<ZbiorMedaliKraju> medaleKrajow) {
        return medaleKrajow.stream()
                .filter(medKra -> medKra.getIloscGOLDmedal() >= 1)
                .map(ZbiorMedaliKraju::getNazwaKraju)
                .collect(Collectors.toList());
    }

    static List<String> znajdzPanstwaZmin1Jakikolwiek(final List<ZbiorMedaliKraju> medaleKrajow) {
        return medaleKrajow.stream()
                .filter(medKra -> medKra.getIloscGOLDmedal() >= 1 || medKra.getIloscBRONZEmedal() >= 1 || medKra.getIloscSilvermedal() >= 1 || medKra.getIlosc4medal() >= 1)
                .map(ZbiorMedaliKraju::getNazwaKraju)
                .collect(Collectors.toList());
    }

    static String znajdzPanstwoZMaxZlotych(final List<ZbiorMedaliKraju> medaleKrajow) {

       return medaleKrajow.stream()
               .collect(Collectors.groupingBy(ZbiorMedaliKraju::getIloscGOLDmedal) )
               .entrySet().stream()
                    .sorted( (kraj1, kraj2) -> Integer.compare(kraj1.getKey(), kraj2.getKey())*-1 )
                    .collect(Collectors.toList())
                        .get(0).getValue().get(0).getNazwaKraju();

        /*
        TreeMap<Integer, String> krajePlusIleZlotych = new TreeMap<>();

        for (final ZbiorMedaliKraju kraj : medaleKrajow) {
            krajePlusIleZlotych.put(kraj.getIloscGOLDmedal(), kraj.getNazwaKraju());
        }

        List<String> wynik = new ArrayList<>(krajePlusIleZlotych.values());
        return wynik.get(wynik.size() - 1);
         */
    }

    static String znajdzKrajzMaxAllMedali(final List<ZbiorMedaliKraju> medaleKrajow) {
        return medaleKrajow.stream()
                .collect(Collectors.groupingBy(kraj -> kraj.getIloscGOLDmedal() + kraj.getIloscSilvermedal() + kraj.getIloscBRONZEmedal() + kraj.getIlosc4medal()) )
                .entrySet().stream()
                    .sorted( (kraj1, kraj2) -> Integer.compare(kraj1.getKey(), kraj2.getKey())*-1 )
                .collect(Collectors.toList()).get(0).getValue().get(0).getNazwaKraju();
    }

    static String znajdzPanstwoZMax4MiejscMedali(final List<ZbiorMedaliKraju> medaleKrajow) {
        return medaleKrajow.stream()
                .sorted(new Comparator<ZbiorMedaliKraju>() {
                    @Override
                    public int compare(final ZbiorMedaliKraju o1, final ZbiorMedaliKraju o2) {
                        int ile4miejsco1 = o1.getIlosc4medal();
                        int ile4miejsco2 = o2.getIlosc4medal();

                        return Integer.compare(ile4miejsco1, ile4miejsco2) * -1;
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

    static List<String> wyszukKrajeGdzieWiecejSrebrNizZlot(final List<ZbiorMedaliKraju> medaleKrajow) {
        return medaleKrajow.stream()
                .filter(kraj -> kraj.getIloscSilvermedal() > kraj.getIloscGOLDmedal())
                .map(ZbiorMedaliKraju::getNazwaKraju)
                .collect(Collectors.toList());
    }

    public static List<String> wyszukKrajeGdzieBronzSrebrZloto(final List<ZbiorMedaliKraju> medaleKrajow) {
        return medaleKrajow.stream()
                .filter(kraj -> kraj.getIloscBRONZEmedal() > kraj.getIloscSilvermedal() && kraj.getIloscSilvermedal() > kraj.getIloscGOLDmedal())
                .map(ZbiorMedaliKraju::getNazwaKraju)
                .collect(Collectors.toList());
    }

    static Map<String, Integer> dajStatsSumyKrajIleMedali(final List<ZbiorMedaliKraju> medaleKrajow) {
        Map<String, Integer> wynik = new LinkedHashMap<>();

        medaleKrajow.stream()
                .sorted(new Comparator<ZbiorMedaliKraju>() {
                    @Override
                    public int compare(final ZbiorMedaliKraju o1, final ZbiorMedaliKraju o2) {
                        int sumaMedalo1 = o1.getIloscGOLDmedal() + o1.getIloscSilvermedal() + o1.getIloscBRONZEmedal();
                        int sumaMedalo2 = o2.getIloscGOLDmedal() + o2.getIloscSilvermedal() + o2.getIloscBRONZEmedal();

                        return Integer.compare(sumaMedalo1, sumaMedalo2) * -1;
                    }
                }).forEach(kraj -> {
            wynik.put(kraj.getNazwaKraju(), kraj.getIloscGOLDmedal() + kraj.getIloscSilvermedal() + kraj.getIloscBRONZEmedal());
        });

        return wynik;
    }

    static int znajdzDominanteSposrodIlosciZlotychMedali(final List<ZbiorMedaliKraju> medaleKrajow) {
        Map<Integer, Integer> wynik = new TreeMap<>();

        List<Integer> ileZloto = medaleKrajow.stream()
                .map(ZbiorMedaliKraju::getIloscGOLDmedal)
                .collect(Collectors.toList());

        List<Integer> czestoscci = ileZloto.stream()
                .map(liczba -> sumujWystapienia(ileZloto, liczba))
                .collect(Collectors.toList());

        for (int i = 0; i < ileZloto.size(); i++) {
            wynik.put(czestoscci.get(i), ileZloto.get(i));
        }

        return new ArrayList<>(wynik.values()).get(wynik.values().size() - 1);
    }
    private static int sumujWystapienia(final List<Integer> wsrodTych, final Integer taLiczba) {
        int wynik = 0;

        for (final Integer liczba : wsrodTych) {
            if (liczba.equals(taLiczba)) {
                wynik++;
            }
        }

        return wynik;
    }

    static String znajdzKrajZMaxOgolnyWynik(final List<ZbiorMedaliKraju> MedaleKrajow) {
        return MedaleKrajow.stream().sorted(new Comparator<ZbiorMedaliKraju>() {
            @Override
            public int compare(final ZbiorMedaliKraju o1, final ZbiorMedaliKraju o2) {
                int punktyO1 = (o1.getIloscGOLDmedal() * 3) + (o1.getIloscSilvermedal() * 2) + o1.getIloscBRONZEmedal();
                int punktyO2 = (o2.getIloscGOLDmedal() * 3) + (o2.getIloscSilvermedal() * 2) + o2.getIloscBRONZEmedal();

                return Integer.compare(punktyO1, punktyO2) * -1;
            }
        }).collect(Collectors.toList()).get(0).getNazwaKraju();
    }

    static int sumujALLMedale(final List<ZbiorMedaliKraju> MedaleKrajow) {
        return MedaleKrajow.stream()
                .mapToInt(kraj -> kraj.getIloscBRONZEmedal() + kraj.getIloscSilvermedal() + kraj.getIloscGOLDmedal())
                .sum();
    }

    static List<ZbiorMedaliKraju> posortujJeWedlugSrebrnych(final List<ZbiorMedaliKraju> jeDoSortu) {
        return jeDoSortu.stream()
                .sorted(new Comparator<ZbiorMedaliKraju>() {
                    @Override
                    public int compare(final ZbiorMedaliKraju o1, final ZbiorMedaliKraju o2) {
                        int ileSrebro1 = o1.getIloscSilvermedal();
                        int ileSrebro2 = o2.getIloscSilvermedal();

                        return Integer.compare(ileSrebro1, ileSrebro2) * -1;
                    }
                }).collect(Collectors.toList());
    }




}

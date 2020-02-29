package ProgrPo23Luty.zad1PlecakiRozsz.PlecakiZadCopy;

public class FasadaPlecakiTesty {
    private final WydzielTestFromTekst obslugaPodzialuTestow;
    private final zczytaczTestowZPliku obslugaCzytaniaPliku;
    private final SerwisPrzydzialuDoPlecak obslugaRozdzielaniaNaTesty;
    private final zapisDoPlikow obslugaZapisywania;

    private final String ZNAK_PODZIALU;
    private final int ILOSC_PLECAK;

    public FasadaPlecakiTesty(final WydzielTestFromTekst obslugaPodzialuTestow, final zczytaczTestowZPliku obslugaCzytaniaPliku, final SerwisPrzydzialuDoPlecak obslugaRozdzielaniaNaTesty, final zapisDoPlikow obslugaZapisywania, final String ZNAK_PODZIALU, final int ILOSC_PLECAK) {
        this.obslugaPodzialuTestow = obslugaPodzialuTestow;
        this.obslugaCzytaniaPliku = obslugaCzytaniaPliku;
        this.obslugaRozdzielaniaNaTesty = obslugaRozdzielaniaNaTesty;
        this.obslugaZapisywania = obslugaZapisywania;
        this.ZNAK_PODZIALU = ZNAK_PODZIALU;
        this.ILOSC_PLECAK = ILOSC_PLECAK;
    }





}

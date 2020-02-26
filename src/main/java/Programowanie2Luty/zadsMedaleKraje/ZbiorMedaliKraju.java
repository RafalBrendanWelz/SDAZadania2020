package Programowanie2Luty.zadsMedaleKraje;


import lombok.Getter;

@Getter
public class ZbiorMedaliKraju {
    private String nazwaKraju;
    private int iloscGOLDmedal;
    private int iloscSilvermedal;
    private int iloscBRONZEmedal;
    private int ilosc4medal;

    public ZbiorMedaliKraju(final String nazwaKraju, final int iloscGOLDmedal, final int iloscSilvermedal, final int iloscBRONZEmedal) {
        this.nazwaKraju = nazwaKraju;
        this.iloscGOLDmedal = iloscGOLDmedal;
        this.iloscSilvermedal = iloscSilvermedal;
        this.iloscBRONZEmedal = iloscBRONZEmedal;
    }

    public ZbiorMedaliKraju(final String nazwaKraju, final int iloscGOLDmedal, final int iloscSilvermedal, final int iloscBRONZEmedal, final int ilosc4Medal) {
        this.nazwaKraju = nazwaKraju;
        this.iloscGOLDmedal = iloscGOLDmedal;
        this.iloscSilvermedal = iloscSilvermedal;
        this.iloscBRONZEmedal = iloscBRONZEmedal;
        this.ilosc4medal = ilosc4Medal;
    }




}

package ProgrPo16Luty.zad1SubjectiInformuje;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class Subject{
    private int wartosc;
    private List<Obserwujacy> obserwujacy;

    Subject(final int wartosc) {
        this.wartosc = wartosc;
        this.obserwujacy = new ArrayList<>();
    }

    void zmienWartosc(final int nowa){
        this.wartosc = nowa;
        poinformujCalaLista();
    }

    void dodajObserwujacego(final Obserwujacy nowy){
        this.obserwujacy.add(nowy);
    }

    private void poinformujCalaLista(){
        this.obserwujacy.forEach(Obserwujacy::reactToInfo);
    }



}

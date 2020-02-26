package ProgrPo16Luty.zad1SubjectiInformuje;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Subject{
    int wartosc;
    List<Obserwujacy> obserwujacy;

    public Subject(final int wartosc) {
        this.wartosc = wartosc;
        this.obserwujacy = new ArrayList<>();
    }

    public void zmienWartosc(int nowa){
        this.wartosc = nowa;
        poinformuj();
    }

    public void dodajObserwujacego(final Obserwujacy nowy ){
        this.obserwujacy.add(nowy);
    }

    public void poinformuj( ){
        this.obserwujacy.forEach( obs -> obs.reactToInfo() );
    }



}

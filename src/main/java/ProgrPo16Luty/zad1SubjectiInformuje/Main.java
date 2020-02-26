package ProgrPo16Luty.zad1SubjectiInformuje;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        Subject liczby = new Subject(10);

        List<Obserwujacy> listaObserw = dajObserw(liczby);

        liczby.zmienWartosc(12);
        liczby.zmienWartosc(-5);
        liczby.zmienWartosc(-7);
        System.out.println(listaObserw.size());

    }

    private static List<Obserwujacy> dajObserw(final Subject doKogo) {
        Obserwujacy pierwszy = new ObsTypeAllValue(doKogo);
        Obserwujacy drugi = new ObsTypeLowerValue(doKogo);
        Obserwujacy trzeci = new ObsTypeChangeOf10(doKogo);

        return List.of(pierwszy, drugi, trzeci);
    }


}

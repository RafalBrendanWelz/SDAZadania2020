package ProgrPo16Luty.zad6LiczOwoceZ1Weekend;

import ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy.Owoc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class HeavyFruitRunnableFinder implements Runnable {
    private static final double WAGA_CIEZKA_OD_KG = 1;
    private static final String[] MOZLIWE_TYPY_OWOC = new String[] {"Jabłko", "Banan", "Magical Grape"};

    private final List<Owoc> allOwoce;
    private final String typDoPrzeszukiwania;
    private final CountDownLatch blokada;

    public HeavyFruitRunnableFinder(final List<Owoc> allOwoce, final TypyOwocow typDoPrzeszukiwania, final CountDownLatch blokada) {
        this.allOwoce = allOwoce;
        this.typDoPrzeszukiwania = typDoPrzeszukiwania.getNazwa();
        this.blokada = blokada;
    }
    public HeavyFruitRunnableFinder(final List<Owoc> allOwoce, final int typDoPrzeszukiwania, final CountDownLatch blokada) {
        this.allOwoce = allOwoce;
        this.typDoPrzeszukiwania = dajFiltrTypu(typDoPrzeszukiwania);
        this.blokada = blokada;
    }
    private String dajFiltrTypu(final int wartosc){
        if (wartosc >= MOZLIWE_TYPY_OWOC.length || wartosc < 0){
            throw new ArrayIndexOutOfBoundsException("Nie ma odpowiadającego typu owocu wśród możliwych w HeavyFruitRunnableFinder." +
                    "\n Dopuszczalne Wartości z przedziału: <0," + (MOZLIWE_TYPY_OWOC.length-1) + ">");
        }else {
            return MOZLIWE_TYPY_OWOC[wartosc];
        }
    }

    @Override
    public void run() {
        List<Owoc> przeszukiwane = allOwoce.stream()
                .filter( owc -> owc.getNazwa().equals(this.typDoPrzeszukiwania) )
                .collect(Collectors.toList());

        List<Owoc> ciezkie = new LinkedList<>();

        for (final Owoc owoc : przeszukiwane) {
            if (owoc.getWaga() >= WAGA_CIEZKA_OD_KG) {
                ciezkie.add(owoc);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (ciezkie.size() >= 10) {
                    break;
                }
            }
        }

        System.out.println(ciezkie + " " + ciezkie.size() + " spośród " + przeszukiwane.size() );
        blokada.countDown();
    }


}

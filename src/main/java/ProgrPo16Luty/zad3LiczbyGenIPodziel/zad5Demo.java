package ProgrPo16Luty.zad3LiczbyGenIPodziel;


import java.util.*;
import java.util.concurrent.*;

public class zad5Demo { //update do zad4Demo (na skopiowanej wersji dopisane)
    private static final int ILOSC_LOSOWYCH_LICZB = 100;
    private static final int MAX_WIELKOSC_LICZBY = 100000;
    private static List<Integer> losoweLiczby = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(losoweLiczby + "\n");
        app2Dzielniki sprawdzaniePodzielnosci = new app2Dzielniki.appBuilder().setDzielnik(4).setDrugiDzielnik(3).build().orElseThrow();

        Thread watek2 = new Thread( new checkPodzielnoscRunnable(whichDzielnikApp2Dzielniki.SECOND, sprawdzaniePodzielnosci, losoweLiczby) );
        Thread watek1 = new Thread( new checkPodzielnoscRunnable(whichDzielnikApp2Dzielniki.FIRST, sprawdzaniePodzielnosci, losoweLiczby) );



        watek1.start();
        watek2.start();

        for (int i = 0; i < ILOSC_LOSOWYCH_LICZB; i++) {
            int nowaLiczba = giveRandomNumber();
            System.out.println("Dodano " + nowaLiczba);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            losoweLiczby.add(nowaLiczba);
        }

    }
    private static Integer giveRandomNumber(){
        return new Random().nextInt(MAX_WIELKOSC_LICZBY);
    }


    private static class checkPodzielnoscRunnable implements Callable, Runnable {
        private whichDzielnikApp2Dzielniki jakiDzielnik;
        private app2Dzielniki runWithThisApp;
        private List<Integer> naLiczbach;

        public checkPodzielnoscRunnable(final whichDzielnikApp2Dzielniki jakiDzielnik, final app2Dzielniki runWithThisApp, final List<Integer> naLiczbach) {
            this.jakiDzielnik = jakiDzielnik;
            this.runWithThisApp = runWithThisApp;
            this.naLiczbach = naLiczbach;
        }

        @Override
        public void run() {
            for (int i = 0; i < ILOSC_LOSOWYCH_LICZB; i++) {
                while (this.naLiczbach.size() <= i){
                    System.out.print("waiting...");
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if ( runWithThisApp.isPodzielne( naLiczbach.get(i), jakiDzielnik) ){
                    System.out.println("Liczba nr." + i + " (" + naLiczbach.get(i) + ") jest podzielna przez " +
                            ( (jakiDzielnik == whichDzielnikApp2Dzielniki.SECOND) ? (runWithThisApp.getDzielnik2()) : (runWithThisApp.getDzielnik1())) );
                }
            }
        }

        @Override
        public Object call() throws Exception {


            return null;
        }
    }



}

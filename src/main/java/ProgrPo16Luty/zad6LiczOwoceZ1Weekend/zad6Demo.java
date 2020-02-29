package ProgrPo16Luty.zad6LiczOwoceZ1Weekend;


import ProgrPo16Luty.zad6LiczOwoceZ1Weekend.OwoceZadFromCopy.Owoc;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zad6Demo {

    public static void main(String[] args) {
        List<Owoc> wszystkieOwoce = new RandomFruitsGenerator(1000000).generujALL();

        CountDownLatch czekajNa3Findery = new CountDownLatch(3);
        Thread szukacz1 = new Thread( new HeavyFruitRunnableFinder(wszystkieOwoce, 0, czekajNa3Findery) );
        Thread szukacz2 = new Thread( new HeavyFruitRunnableFinder(wszystkieOwoce, 1, czekajNa3Findery) );
        Thread szukacz3 = new Thread( new HeavyFruitRunnableFinder(wszystkieOwoce, 2, czekajNa3Findery) );

        LocalTime czasStart = LocalTime.now();
        szukacz1.start();
        szukacz2.start();
        szukacz3.start();
        try {
            czekajNa3Findery.await(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Duration findingTime = Duration.between(LocalTime.now(), czasStart);
        System.out.println("Szukanie ciężkich owoców zajęło " + TimeUnit.NANOSECONDS.toMillis(findingTime.getNano())  + " MiliSekund" );

    }



}

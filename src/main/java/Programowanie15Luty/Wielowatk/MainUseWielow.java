package Programowanie15Luty.Wielowatk;

import lombok.SneakyThrows;

public class MainUseWielow {

    public static void main(String[] args) throws InterruptedException {

        Thread pierwszy = new Thread(new Runnable() {

            @Override
            public synchronized void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("To jest działający wątek nr." + Thread.currentThread().getId());
            }
        });

        pierwszy.start();
        System.out.println("A o to główny wątek nr." + Thread.currentThread().getId());
        pierwszy.join();

    }




}

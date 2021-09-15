package de.gothaer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

       new Main().run();



    }

    private void run() {
        try {
            ExecutorService service = Executors.newFixedThreadPool(8);
            for(int i = 0; i < 20; i++)
                service.execute(this::foo);
            service.shutdown();
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void foo() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(String.format("Thread Nr. %s finished.",Thread.currentThread().getId()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

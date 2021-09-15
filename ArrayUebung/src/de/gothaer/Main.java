package de.gothaer;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE >> 1;
    private int feld[] = new int[MAX_ARRAY_SIZE];

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        new Main().run();


    }

    private void run() {
        Random random = new Random();
        Instant start = Instant.now();
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            feld[i] = random.nextInt();
        }
        Instant ende = Instant.now();
        Duration duration = Duration.between(start, ende);
        System.out.println("Duration = " + duration.toMillis());
    }
}

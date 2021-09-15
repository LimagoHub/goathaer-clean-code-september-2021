package de.gothaer.arrays.impl;

import de.gothaer.arrays.ArrayService;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayServiceImpl implements ArrayService {

    private final int availableProcessors = Runtime.getRuntime().availableProcessors();
    private int threadCount;
    private int currentSegment;
    private ExecutorService service;
    private int [] array;
    final Random random = new Random();
    @Override
    public void detectMostEfficientArrayFiller(int[] array) {
        this.array = array;
        fillArrayWithRandomNumbersParallel();
    }

    private void fillArrayWithRandomNumbersParallel() {
        for (threadCount = 1; threadCount <= availableProcessors + 1; threadCount ++) {
           timeMeasureWrapper(this::startExecutorServiceForSegmentSplitting);

        }
    }

    private void startExecutorServiceForSegmentSplitting() {
        try {
            startExecutorServiceForSegmentSplittingImpl();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void startExecutorServiceForSegmentSplittingImpl() throws InterruptedException {
        service = Executors.newFixedThreadPool(availableProcessors);
        startSegmentWorkers();
        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startSegmentWorkers() {
        for(currentSegment = 0; currentSegment < threadCount; currentSegment ++) {
            startSingleSegmentWorker();
        }
    }

    private void startSingleSegmentWorker() {
        final int segmentSize = array.length / threadCount;
        final int start = currentSegment * segmentSize;
        final int ende = (currentSegment + 1) * segmentSize;
        service.execute(new FillSegmentWorker(start,ende));
    }

    @Override
    public int findMaxValue(int[] array) {
        return 0;
    }

    void timeMeasureWrapper(Runnable runnable) {
        Instant start = Instant.now();
        runnable.run();
        Instant ende = Instant.now();
        Duration duration = Duration.between(start, ende);
        System.out.println(String.format("Dauer mit %s Threads waren %s Millisekunden.", threadCount, duration.toMillis()));
    }



    class FillSegmentWorker implements Runnable {

        final Random random = new Random();
        private final int start;
        private final int ende;

        public FillSegmentWorker(final int start, final int ende) {
            this.start = start;
            this.ende = ende;
        }

        @Override
        public void run() {
            for (int i = start; i < ende; i++) {
                array[i] = random.nextInt();
            }
        }
    }
}

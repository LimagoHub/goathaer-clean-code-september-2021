package de.gothaer;

import de.gothaer.arrays.ArrayService;
import de.gothaer.arrays.impl.ArrayServiceImpl;

public class Main {

    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE >> 1;
    private int feld[] = new int[MAX_ARRAY_SIZE];

    public static void main(String[] args) {


        new Main().run();


    }

    private void run() {
        ArrayService arrayService = new ArrayServiceImpl();
        arrayService.detectMostEfficientArrayFiller(feld);
    }
}

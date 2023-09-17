package edu.example.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    private final static int INCREMENT_AMOUNT = 10000;
    private final static int NUM_THREADS = 3;
    private final static int START_VALUE = 1;

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(START_VALUE);
        List<CounterThread> threads = new ArrayList<>();
        for (int i = 0; i < NUM_THREADS; i++) {
            CounterThread thread = new CounterThread(counter, INCREMENT_AMOUNT);
            thread.start();
            threads.add(thread);
        }
        for (CounterThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        System.out.println("Counter: " + counter.get());
    }
}



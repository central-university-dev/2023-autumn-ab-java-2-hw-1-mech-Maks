package edu.example.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter(1);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Thread thread = new IncrementingThread(counter);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Main thread was interrupted");
            }
        }

        System.out.println("Final counter value: " + counter.getCounterValue());
    }
}

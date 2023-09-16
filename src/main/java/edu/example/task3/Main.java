package edu.example.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(1);
        Runnable task = () -> {
            for (int x = 0; x < 10000; x++) {
                counter.incrementAndGet();
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int x = 0; x < 3; x++) {
            executor.submit(task);
        }
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println(counter);
    }
}

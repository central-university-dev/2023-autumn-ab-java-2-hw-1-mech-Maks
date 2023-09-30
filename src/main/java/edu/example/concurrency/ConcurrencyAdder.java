package edu.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyAdder {
    private static final int THREADS = 3;
    private static final int ITERATIONS = 10000;
    private static final AtomicInteger count = new AtomicInteger(1);

    public static void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        Runnable task = () -> {
            for (int i = 0; i < ITERATIONS; ++i) {
                int value = count.incrementAndGet();
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "; value: " + value);
            }
        };
        
        for (int i = 0; i < THREADS; ++i) {
            executorService.submit(task));
        }
        awaitAndShutdown(executorService);

        System.out.println("Total `count`: " + count);
    }

    public static int getCount() {
        return count.get();
    }

    private static void awaitAndShutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

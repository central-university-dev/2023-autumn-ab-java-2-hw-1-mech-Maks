package edu.example.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Перенёс из отдельного репозитория
 */
public class App {

    private static AtomicInteger counter = new AtomicInteger(1);


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(
                    () -> {
                        for (int j = 0; j < 10000; j++) {
                            // Надеюсь правильно понял, что такое кол-во кода лучше оставить в лямбде
                            counter.incrementAndGet();
                        }
                    }
            );
        }

        executorService.shutdown();

        // Ждём пока потоки завершатся
        try {
            executorService.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Threads Error :(");
        }

        System.out.println(counter);
    }
}

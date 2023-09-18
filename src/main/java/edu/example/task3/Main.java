package edu.example.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        AtomicInteger counter = new AtomicInteger(1);
        for (int j = 0; j < 3; ++j) {
            executorService.submit(() -> {
                        for (int i = 0; i < 10000; ++i) {
                            counter.addAndGet(1);
                        }
                    }
            );
        }
        executorService.shutdown();
        // можно цикл организовать, но мне захотелось текст вывести
        if (executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("Хух, успел посчитать " + counter.get());
        } else {
            System.out.println("Простите, я опоздал");
        }
    }
}

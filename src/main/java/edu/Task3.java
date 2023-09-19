package edu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger one = new AtomicInteger(1);
        System.out.println("Initial value: " + one.get());

        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++)
            es.execute(() -> {
                for (int j = 0; j < 10000; j++)
                    one.incrementAndGet();
            });

        es.shutdown();
        while (!es.isTerminated())
            Thread.sleep(100);

        System.out.println("Final value: " + one.get());
    }

}

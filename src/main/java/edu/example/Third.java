package edu.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Third {
    private static AtomicInteger cnt = new AtomicInteger(1);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Future<?>> tasks = List.of(
                service.submit(new Sum()),
                service.submit(new Sum()),
                service.submit(new Sum())
        );
        service.shutdown();
        while (!service.isTerminated());
        System.out.println(cnt.get());
    }

    static class Sum implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                cnt.incrementAndGet();
            }
        }
    }
}
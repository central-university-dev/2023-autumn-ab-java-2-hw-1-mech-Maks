package task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
        final int POOL_SIZE = 3;
        final int INCREMENTS_COUNT = 10000;
        // final int RESULT = 30001;

        AtomicInteger count = new AtomicInteger(1);

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; i++) {
            executor.execute(() -> {
                for (int j = 0; j < INCREMENTS_COUNT; j++) {
                    count.incrementAndGet();
                }
            });
        }

        executor.shutdown();

        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}

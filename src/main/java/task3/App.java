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

        var incrementor = new Incrementor(count, INCREMENTS_COUNT);

        for (int i = 0; i < POOL_SIZE; i++) {
            executor.execute(incrementor);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                    System.out.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }

        System.out.println(count);
    }
}

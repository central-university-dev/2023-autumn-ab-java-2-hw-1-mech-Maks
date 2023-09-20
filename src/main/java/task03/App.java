package task03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger number = new AtomicInteger(1);
        int threadsCount = 3;
        int incrementsCount = 10000;

        Runnable task = () -> {
            for (int i = 0; i < incrementsCount; i++) {
                number.incrementAndGet();
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(threadsCount);
        List<Future> tasks = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            tasks.add(service.submit(task));
        }

        service.shutdown();

        service.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println(number);
    }
}

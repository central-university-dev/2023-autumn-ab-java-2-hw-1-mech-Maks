package edu.example.task3;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(1);
        ExecutorService service = Executors.newFixedThreadPool(3);
        try {
            List<Future<?>> futures = Stream.of(
                    new IncrementRunnable(counter),
                    new IncrementRunnable(counter),
                    new IncrementRunnable(counter)
            ).map(service::submit).collect(Collectors.toList());
            for (Future<?> f : futures) {
                f.get();
            }
            System.out.println("counter: " + counter.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }
}

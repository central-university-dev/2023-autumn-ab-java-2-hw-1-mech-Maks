package task3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task3 {
    private static final int THREADS = 3;
    private static final int INCREMENT_COUNT = 10000;
    static final ConcurrentCounter concurrentCounter = new ConcurrentCounter();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        var threads = Stream.generate(() -> executor.submit(Task3::incrementCounter))
                .limit(3)
                .collect(Collectors.toList());
        for (var thread : threads) {
            try {
                thread.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();
        System.out.println(concurrentCounter.get());
    }

    private static void incrementCounter() {
        for (int i = 0; i < INCREMENT_COUNT; i++) {
            concurrentCounter.increment();
        }
    }
}

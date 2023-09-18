package edu.example.task3;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
    public static void main(String[] args) {
        Variable task = new Variable();

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            service.execute(task);
        }

        // disable new tasks from being submitted
        service.shutdown();
        try {
            // waiting for existing tasks to terminate
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                // cancel existing tasks
                service.shutdownNow();
                if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool didn't terminate");
                }
            }
            else {
                System.out.println(task.getX());
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }

    }
}

@Getter
class Variable implements Runnable {
    private final AtomicInteger x = new AtomicInteger(1);
    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            x.incrementAndGet();
        }
    }
}

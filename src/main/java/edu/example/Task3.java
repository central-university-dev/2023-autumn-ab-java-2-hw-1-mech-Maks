package edu.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;


public class Task3 {
    static AtomicInteger x = new AtomicInteger(1);

    public static void main(String[] args) {

        CompletableFuture<Void> futures = CompletableFuture.allOf(
                createFuture(),
                createFuture(),
                createFuture()
        );
        futures.thenApply(unused -> {
            System.out.println(x.get());
            return null;
        });
    }

    private static CompletableFuture<Void> createFuture() {
        return CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10000; i++) {
                x.incrementAndGet();
            }
        });
    }
}

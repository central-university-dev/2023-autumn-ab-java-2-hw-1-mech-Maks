package edu.example.task3;

import java.util.concurrent.atomic.AtomicInteger;

public class Action {
    private final AtomicInteger count = new AtomicInteger(1);

    public void increments() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " count " + count.getAndIncrement());
        }
    }

    public int getCount() {
        return count.get();
    }
}
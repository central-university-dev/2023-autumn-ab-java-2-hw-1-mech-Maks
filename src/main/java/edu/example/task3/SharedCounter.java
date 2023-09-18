package edu.example.task3;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {

    private final AtomicInteger counter;

    public SharedCounter(int initialValue) {
        counter = new AtomicInteger(initialValue);
    }

    public int getCounterValue() {
        return counter.intValue();
    }

    public void increment() {
        counter.incrementAndGet();
    }
}

package edu.example.task3;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
class IncrementRunnable implements Runnable {
    private AtomicInteger counter;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.incrementAndGet();
        }
    }
}


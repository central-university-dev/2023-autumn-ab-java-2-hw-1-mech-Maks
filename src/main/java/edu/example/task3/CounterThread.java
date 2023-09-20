package edu.example.task3;

import java.util.concurrent.atomic.AtomicInteger;

class CounterThread extends Thread {

    private AtomicInteger counter;
    private int incrementAmount;

    public CounterThread(AtomicInteger counter, int incrementAmount) {
        this.counter = counter;
        this.incrementAmount = incrementAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementAmount; i++) {
            counter.incrementAndGet();
        }
    }
}
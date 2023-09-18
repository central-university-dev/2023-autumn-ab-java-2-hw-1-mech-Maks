package edu.example.task3;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
class CountThread extends Thread {
    private AtomicInteger count;
    private int amountToIncrement;

    @Override
    public void run() {
        for (int i = 0; i < amountToIncrement; i++) {
            count.incrementAndGet();
        }
    }
}


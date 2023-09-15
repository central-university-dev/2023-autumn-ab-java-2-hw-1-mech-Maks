package edu.ThirdTask;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementor implements Runnable {
    private final AtomicInteger integer;

    public Incrementor(AtomicInteger integer) {
        this.integer = integer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++)
            integer.incrementAndGet();
    }
}

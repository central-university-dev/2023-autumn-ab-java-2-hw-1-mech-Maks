package edu.week01.task3;

import java.util.concurrent.atomic.AtomicInteger;

public class Threading {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(1);

        Runnable runner = () -> increment(counter);

        Thread t1 = new Thread(runner);
        Thread t2 = new Thread(runner);
        Thread t3 = new Thread(runner);

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        System.out.println(counter.get());
    }

    public static void increment(AtomicInteger counter) {
        for (int i = 0; i < 10000; ++i) {
            counter.addAndGet(1);
        }
    }
}
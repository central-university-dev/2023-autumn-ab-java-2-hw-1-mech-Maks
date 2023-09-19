package edu.example.task3;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Incrementor implements Runnable{

    private AtomicInteger i = new AtomicInteger(1);

    @Override
    public void run() {
        for (int j = 0; j < 10_000; ++j) {
            //System.out.println("Thread " + Thread.currentThread().getName() + " count " + i);
            i.incrementAndGet();
        }
    }

}

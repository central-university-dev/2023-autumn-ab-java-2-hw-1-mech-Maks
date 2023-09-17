package edu.example;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class IncrementTask implements Runnable {
    @Getter
    private static int count = 1;

    @Override
    public void run() {
        for (int i = 0; i < 10000; ++i) {
            synchronized (IncrementTask.class) {
                ++count;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; ++i) {
            service.submit(new IncrementTask());
        }

        service.shutdown();
        while (!service.isTerminated());

        System.out.println("Результат: " + IncrementTask.getCount());
    }
}



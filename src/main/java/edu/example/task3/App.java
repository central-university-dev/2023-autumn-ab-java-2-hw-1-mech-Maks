package edu.example.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
        AtomicInteger k = new AtomicInteger(1);
        List<CountThread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CountThread thread = new CountThread(k, 10000);
            threads.add(thread);
            thread.start();
        }
        for (CountThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

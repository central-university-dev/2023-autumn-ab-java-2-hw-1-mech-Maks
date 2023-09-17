package edu.week01.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading {

    public static void main(String[] args) {
        final int start = 1;
        final int end = 30001;
        final int incrementPerThread = 10000;
        final int numThreads = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i <= numThreads; i++) {
            int threadStart = start + i * incrementPerThread;
            int threadEnd = threadStart + incrementPerThread - 1;
            if (threadEnd > end) {
                threadEnd = end;
            }

            Runnable task = new IncrementTask(threadStart, threadEnd);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}

class IncrementTask implements Runnable {
    private final int start;
    private final int end;

    public IncrementTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
        }
    }
}

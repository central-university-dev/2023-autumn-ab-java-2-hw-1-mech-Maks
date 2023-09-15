package edu.example.task3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCounter {
    public static void main(String[] args){
        Action action = new Action();
        Runnable runnable = action::increments;

        int numThreads = 3;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executor.submit(runnable);
        }

        executor.shutdown();
        while (!executor.isTerminated()){
        }
        System.out.println(action.getCount());
    }
}

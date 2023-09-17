package edu.example;

import edu.example.processors.LogProcessor;
import edu.example.processors.RemoveFriendProcessor;
import edu.example.processors.SwapParentsProcessor;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
        processPerson();
        printSectionSeparator();
        incrementParallel();
    }

    public static void processPerson() {
        System.out.println("Start person processing");
        List<PersonProcessor> processors = List.of(
                new SwapParentsProcessor(),
                new LogProcessor(),
                new RemoveFriendProcessor()
        );
        Person mother = new Person("Mother");
        Person father = new Person("Father");
        Person friend = new Person("Friend");
        Person person = new Person("Man", mother, father, friend);

        System.out.println("Person before processing:");
        System.out.println(person);

        processors.forEach(f -> f.process(person));

        System.out.println("Person after processing:");
        System.out.println(person);
    }

    public static void incrementParallel() {
        System.out.println("Start parallel incrementing");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        AtomicInteger counter = new AtomicInteger(1);
        Runnable incrementTask = () -> {
            System.out.println("Start incrementing in thread with id " + Thread.currentThread().getId());
            boolean wasInterrupted = false;
            for (int i = 0; i < 10000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    Thread.currentThread().interrupt();
                    wasInterrupted = true;
                    break;
                }
                counter.getAndIncrement();
            }
            if (wasInterrupted) {
                System.out.println("Stopping because of interruption");
            } else {
                System.out.println("End incrementing in thread with id " + Thread.currentThread().getId());
            }
        };

        Future<?> future1 = executorService.submit(incrementTask);
        Future<?> future2 = executorService.submit(incrementTask);
        Future<?> future3 = executorService.submit(incrementTask);

        try {
            future1.get();
            future2.get();
            future3.get();
        } catch (InterruptedException e) {
            System.out.println("Stopping because of interruption");
            stopExecution(executorService);
            System.out.println("Stopped execution");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("Some error occurred while calculation: " + e.getMessage());
            System.out.println("Stopping execution");
            stopExecution(executorService);
            System.out.println("Stopped execution");
        }
        executorService.shutdown();
        System.out.println("Successfully incremented counter. It's current value is " + counter.get());
    }

    private static void stopExecution(ExecutorService executorService) {
        executorService.shutdownNow();

        boolean threadWasInterrupted = false;
        while (true) {
            try {
                boolean terminationFinished = executorService.awaitTermination(1, TimeUnit.SECONDS);
                if (terminationFinished) {
                    break;
                }
            } catch (InterruptedException e) {
                threadWasInterrupted = true;
            }
        }
        if (threadWasInterrupted) {
            Thread.currentThread().interrupt();
        }
    }

    private static void printSectionSeparator() {
        System.out.println("- - - - - - - - - - - - - - - -");
    }
}

package edu.example;

import PersonProcessors.LogChangedProcessor;
import PersonProcessors.RemoveFriendProcessor;
import PersonProcessors.SwapParentsProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) {
        System.out.println("Start person task");
        PersonProcessorsTask();
        System.out.println("\nStart increment thread task");
        IncrementThreadTask();
    }

    private static void IncrementThreadTask() {
        int numberIterations = 10000;
        int numberThreads = 3;

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberThreads);

        List<Callable<Void>> taskList = new ArrayList<>();
        for (int i = 0; i < numberThreads; i++) {
            taskList.add(() -> IncrementThread.run(numberIterations));
        }

        try {
            executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        executor.shutdown();
        System.out.println(IncrementThread.counter);
    }

    public static void PersonProcessorsTask() {
        Person mother = new Person("mother", null, null, null);
        Person father = new Person("father", null, null, null);
        Person friend = new Person("friend", null, null, null);
        Person person = new Person("I", mother, father, friend);

        List<Person> collect = Optional.ofNullable(person)
                .stream()
                .peek(new RemoveFriendProcessor())
                .collect(Collectors.toList());

        if (collect.get(0).friend != null)
            throw new IllegalArgumentException();

        collect = Optional.ofNullable(person)
                .stream()
                .peek(new SwapParentsProcessor())
                .collect(Collectors.toList());

        if (!Objects.equals(collect.get(0).mother, father) || !Objects.equals(collect.get(0).father, mother))
            throw new IllegalArgumentException();

        Optional.ofNullable(person)
                .stream()
                .peek(new LogChangedProcessor())
                .collect(Collectors.toList());
    }
}

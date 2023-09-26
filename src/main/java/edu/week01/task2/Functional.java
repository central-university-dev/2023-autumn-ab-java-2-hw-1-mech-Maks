package edu.week01.task2;

import edu.week01.task2.processors.LogProcessor;
import edu.week01.task2.processors.SwapParentsProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Functional {
    public static void main(String[] args) {
        Person person1 = new Person("Mother");
        Person person2 = new Person("Father");
        Person person3 = new Person("Child", person1, person2);

        System.out.println(person3);

        SwapParentsProcessor swapParentsProcessor = new SwapParentsProcessor();
        LogProcessor logProcessor = new LogProcessor();

        List<Consumer<Person>> personProcessors = List.of(swapParentsProcessor, logProcessor);
        personProcessors.forEach(process -> process.accept(person3));


        System.out.println(person3);
    }
}

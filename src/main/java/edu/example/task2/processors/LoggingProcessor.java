package edu.example.task2.processors;

import edu.example.task2.Person;

import java.util.function.Consumer;

public class LoggingProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        System.out.println("changed");
    }
}

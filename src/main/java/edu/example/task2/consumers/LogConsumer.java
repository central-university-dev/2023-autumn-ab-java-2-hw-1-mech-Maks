package edu.example.task2.consumers;

import edu.example.task2.Person;

import java.util.function.Consumer;

public class LogConsumer implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        System.out.println("changed");
    }
}

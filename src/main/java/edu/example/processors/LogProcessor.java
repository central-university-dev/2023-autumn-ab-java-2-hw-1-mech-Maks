package edu.example.processors;

import edu.example.Person;

import java.util.function.Consumer;

public class LogProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        System.out.println("changed: " + person);
    }
}

package org.example.processors;

import org.example.Person;

import java.util.function.Consumer;
import java.util.function.Function;

public class LogProcessor implements Function<Person, Person> {

    @Override
    public Person apply(Person person) {
        System.out.println("Changed");
        return person;
    }
}

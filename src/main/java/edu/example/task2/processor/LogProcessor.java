package edu.example.task2.processor;

import edu.example.task2.Person;

import java.util.Optional;
import java.util.function.Consumer;

public class LogProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        System.out.println("Swapped: mother " +
                Optional.ofNullable(person.getMother()).map(Person::getName).orElse(null) +
                " with father " +
                Optional.ofNullable(person.getFather()).map(Person::getName).orElse(null) + "\n" +
                "No more " +
                Optional.ofNullable(person.getFriend()).map(Person::getName).orElse(null) + " friend\n");
    }

}

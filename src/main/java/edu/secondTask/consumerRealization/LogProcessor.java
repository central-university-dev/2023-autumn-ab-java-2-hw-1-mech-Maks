package edu.secondTask.consumerRealization;

import edu.secondTask.Person;

import java.util.function.Consumer;

public class LogProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        System.out.println(person + " changed");
    }
}

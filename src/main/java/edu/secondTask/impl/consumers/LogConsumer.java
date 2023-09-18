package edu.secondTask.impl.consumers;

import edu.secondTask.Person;

import java.util.function.Consumer;

public class LogConsumer implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        System.out.println(person + " changed");
    }
}

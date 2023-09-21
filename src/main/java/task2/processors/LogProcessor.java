package task2.processors;

import task2.Person;

import java.util.function.Consumer;

public class LogProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        System.out.println("changed");
    }
}

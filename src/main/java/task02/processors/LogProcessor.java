package task02.processors;

import task02.Person;

import java.util.function.Consumer;

public class LogProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        System.out.println("changed");
    }
}

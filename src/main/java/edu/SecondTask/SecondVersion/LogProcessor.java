package edu.SecondTask.SecondVersion;

import edu.SecondTask.Person;

import java.util.function.Consumer;

public class LogProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        System.out.println(person + " changed");
    }
}

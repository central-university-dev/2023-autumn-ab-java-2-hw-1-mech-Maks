package edu.week01.task2.processors;


import edu.week01.task2.Person;

import java.util.function.Consumer;

public class LogProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        System.out.println("logging : " + person);
    }
}
package edu.example.task2.processors;

import edu.example.task2.Person;
import edu.example.task2.PersonProcessor;

public class LogProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        System.out.println("changed");
    }
}

package edu.secondTask.impl.processors;

import edu.secondTask.Person;
import edu.secondTask.api.PersonProcessor;

public class LogProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        System.out.println(person + " changed");
    }
}

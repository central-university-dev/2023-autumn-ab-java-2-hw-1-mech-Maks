package edu.secondTask.processorRealization;

import edu.secondTask.Person;

public class LogProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        System.out.println(person + " changed");
    }
}

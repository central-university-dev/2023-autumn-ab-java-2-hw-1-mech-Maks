package edu.secondTask.api;

import edu.secondTask.Person;

@FunctionalInterface
public interface PersonProcessor {
    void process(Person person);
}

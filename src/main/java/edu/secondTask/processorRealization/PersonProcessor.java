package edu.secondTask.processorRealization;

import edu.secondTask.Person;

@FunctionalInterface
public interface PersonProcessor {
    void process(Person person);
}

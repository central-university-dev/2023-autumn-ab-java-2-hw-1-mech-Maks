package edu.example.processors;

import edu.example.Person;

@FunctionalInterface
public interface PersonProcessor {
    void process(Person person);
}

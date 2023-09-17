package edu.example.processors;

import edu.example.Person;
import edu.example.PersonProcessor;

public class LogProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        System.out.println("Changed");
    }
}

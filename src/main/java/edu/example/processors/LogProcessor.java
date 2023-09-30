package edu.example.processors;

import edu.example.Person;

public class LogProcessor implements PersonProcessor {
    private final String message;

    public LogProcessor(String message) {
        this.message = message;
    }

    public LogProcessor() {
        this("");
    }

    @Override
    public void process(Person person) {
        System.out.println(message);
    }
}

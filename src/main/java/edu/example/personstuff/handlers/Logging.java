package edu.example.personstuff.handlers;

import edu.example.personstuff.Person;

public class Logging implements Handler<Person> {
    @Override
    public void handle(Person person) {
        System.out.println(person.toString());
    }
}

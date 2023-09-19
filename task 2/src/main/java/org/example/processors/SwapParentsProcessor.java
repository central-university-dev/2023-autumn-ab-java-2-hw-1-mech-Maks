package org.example.processors;

import org.example.Person;

import java.util.function.Function;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public Person apply(Person person) {
        Person mother = person.getMother();
        person.setMother(person.getFather());
        person.setFather(mother);
        return person;
    }
}

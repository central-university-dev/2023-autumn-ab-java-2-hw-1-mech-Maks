package edu.example.processor;

import edu.example.Person;
import edu.example.PersonProcessor;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        if (person == null) return;
        Person tmp = person.getFather();
        person.setFather(person.getMother());
        person.setMother(tmp);
    }
}

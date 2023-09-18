package edu.example.task2.processors;

import edu.example.task2.Person;
import edu.example.task2.PersonProcessor;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        Person tempParent = person.getFather();
        person.setFather(person.getMother());
        person.setMother(tempParent);
    }
}

package edu.example.task2.processors;

import edu.example.task2.Person;
import edu.example.task2.PersonProcessor;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        Person temp = person.getMother();
        person.setMother(person.getFather());
        person.setFather(temp);
    }
}

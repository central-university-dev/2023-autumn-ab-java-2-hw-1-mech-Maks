package edu.example.processors;

import edu.example.Person;
import edu.example.PersonProcessor;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        Person mother = person.getMother();
        Person father = person.getFather();
        person.setMother(father);
        person.setFather(mother);
    }
}

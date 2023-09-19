package edu.example.processors;

import edu.example.Person;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        var father = person.getFather();
        var mother = person.getMother();
        person.setMother(father);
        person.setFather(mother);
    }
}

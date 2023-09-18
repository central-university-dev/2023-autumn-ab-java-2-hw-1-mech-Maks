package edu.secondTask.impl.processors;

import edu.secondTask.Person;
import edu.secondTask.api.PersonProcessor;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        Person tmpSwap = person.getFather();

        person.setFather(person.getMother());
        person.setMother(tmpSwap);
    }
}

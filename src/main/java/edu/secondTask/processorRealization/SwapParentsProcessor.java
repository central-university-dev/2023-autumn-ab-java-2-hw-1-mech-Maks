package edu.secondTask.processorRealization;

import edu.secondTask.Person;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        Person tmpSwap = person.getFather();

        person.setFather(person.getMother());
        person.setMother(tmpSwap);
    }
}

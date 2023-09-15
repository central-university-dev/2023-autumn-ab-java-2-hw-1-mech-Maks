package edu.SecondTask.FirstVersion;

import edu.SecondTask.Person;

public class SwapParentsProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        Person tmpSwap = person.getFather();

        person.setFather(person.getMother());
        person.setMother(tmpSwap);
    }
}

package edu.SecondTask.SecondVersion;

import edu.SecondTask.Person;

import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        Person tmpSwap = person.getFather();

        person.setFather(person.getMother());
        person.setMother(tmpSwap);
    }
}

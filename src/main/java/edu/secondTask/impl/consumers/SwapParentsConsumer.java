package edu.secondTask.impl.consumers;

import edu.secondTask.Person;

import java.util.function.Consumer;

public class SwapParentsConsumer implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        Person tmpSwap = person.getFather();

        person.setFather(person.getMother());
        person.setMother(tmpSwap);
    }
}

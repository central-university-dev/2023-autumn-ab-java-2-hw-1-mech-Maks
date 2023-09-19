package edu.example.processors;

import edu.example.Person;

import java.util.function.Consumer;

public class SwapParentsConsumer implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        var fatherBefore = person.getFather();
        person.setFather(person.getMother());
        person.setMother(fatherBefore);
    }
}

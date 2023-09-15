package edu.example.processors;

import edu.example.Person;

import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        var tmp = person.getFather();
        person.setFather(person.getMother());
        person.setMother(tmp);
    }
}

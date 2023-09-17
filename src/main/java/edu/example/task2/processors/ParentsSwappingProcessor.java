package edu.example.task2.processors;

import edu.example.task2.Person;

import java.util.function.Consumer;

public class ParentsSwappingProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        Person oldFather = person.getFather();
        person.setFather(person.getMother());
        person.setMother(oldFather);
    }
}

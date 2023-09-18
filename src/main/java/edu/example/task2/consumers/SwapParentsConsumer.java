package edu.example.task2.consumers;

import edu.example.task2.Person;

import java.util.function.Consumer;

public class SwapParentsConsumer implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        Person temp = person.getFather();
        person.setFather(person.getMother());
        person.setMother(temp);
    }
}

package edu.example.task2.processor;

import edu.example.task2.Person;

import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        Person mother = person.getMother();
        person.setMother( person.getFather() );
        person.setFather( mother );
    }

}

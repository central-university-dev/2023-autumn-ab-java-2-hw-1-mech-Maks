package edu.week01.task2.processors;


import edu.week01.task2.Person;

import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        if (person != null) {
            Person temp = person.getFather();
            person.setFather(person.getMother());
            person.setMother(temp);
        }
    }
}

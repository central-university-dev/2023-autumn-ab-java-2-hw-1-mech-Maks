package edu.example;

import java.util.function.Consumer;

public class ParentSwapper<T extends Person> implements Consumer<T> {

    @Override
    public void accept(T person) {
        // swap mum and dad
        Person father = person.getFather();
        person.setFather(person.getMother());
        person.setMother(father);
    }
}

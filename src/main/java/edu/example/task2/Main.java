package edu.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class Main {
    public static void main(String[] args) {
        List<Consumer<Person>> processors = new ArrayList<>();
        processors.add(person -> {
            var mother = person.getMother();
            person.setMother(person.getFather());
            person.setFather(mother);
        });
        processors.add((person) -> System.out.println("changed " + person.toString()));
        processors.add(person -> person.setFriend(null));

        var person1 = new Person("mother");
        var person2 = new Person("father");
        var person = new Person("son", person1, person2, person2);

        processors.forEach(processor -> processor.accept(person));

        System.out.println(person);
    }
}
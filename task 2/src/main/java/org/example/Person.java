package org.example;

import lombok.Data;
import lombok.ToString;

import java.util.stream.Stream;

@Data
@ToString(callSuper = true)
public class Person {
    private Person mother;
    private Person father;
    private Person friend;
    public static Person swapParents(Person person) {
        Person mother = person.mother;
        person.mother = person.father;
        person.father = mother;
        return person;
    }
}
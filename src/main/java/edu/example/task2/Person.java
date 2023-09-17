package edu.example.task2;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Person mother;
    private Person father;
    private Person friend;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", mother=" + Optional.ofNullable(mother).map(Person::getName).orElse("NoMother") +
                ", father=" + Optional.ofNullable(father).map(Person::getName).orElse("NoFather") +
                ", friend=" + Optional.ofNullable(friend).map(Person::getName).orElse("NoFriend") +
                '}';
    }
}

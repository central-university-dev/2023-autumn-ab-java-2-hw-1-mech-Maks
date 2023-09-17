package edu.example.personstuff;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    String name;
    private Person mother;
    private Person father;
    private Person friend;
    public Person(String name, Person mother, Person father, Person friend){
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.friend = friend;
    }
}

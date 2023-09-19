package edu.example.personstuff;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private final String name;
    private Person mother;
    private Person father;
    private Person friend;
    public Person(String name, Person mother, Person father, Person friend){
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.friend = friend;
    }

    @Override
    public String toString(){
        return "Changed";
    }
}

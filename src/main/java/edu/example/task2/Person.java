package edu.example.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private Person mother;
    private Person father;
    private Person friend;

    public Person(String name) {
        this.name = name;
    }
}

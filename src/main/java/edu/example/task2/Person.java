package edu.example.task2;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Person father;
    private Person mother;
    private Person friend;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
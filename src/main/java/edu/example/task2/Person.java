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

    @Override
    public String toString() {
        return String.format("%s has father - %s, mother - %s and friend - %s",
                name,
                this.father != null ? this.father.name : null,
                this.mother != null ? this.mother.name : null,
                this.friend != null ? this.friend.name : null
        );
    }
}
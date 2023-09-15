package edu.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Person mother;
    private Person father;
    private Person friend;

    @Override
    public String toString() {
        return
                "Name = " + (name == null ? "-" : name)
                + "; Father = " + (father == null ? "Unknown" : father.getName())
                + "; Mother = " + (mother == null ? "Unknown" : mother.getName())
                + "; Friend = " + (friend == null ? "Unknown" : friend.getName());
    }
}

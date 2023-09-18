package edu.example.task2;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class Person {
    @NonNull
    private String name;
    private Person mother;
    private Person father;
    private Person friend;

    @Override
    public String toString() {
        return this.name;
    }
}

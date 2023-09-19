package org.example;

import lombok.Data;
import lombok.ToString;

import java.util.stream.Stream;

@Data
@ToString
public class Person {
    private String name;
    private Person mother;
    private Person father;
    private Person friend;
}
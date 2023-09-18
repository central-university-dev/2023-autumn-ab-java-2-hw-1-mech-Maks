package org.example;

import lombok.Data;
import lombok.ToString;

import java.util.stream.Stream;

@Data
@ToString(callSuper = true)
public class Person {
    private Person mother;
    private Person father;
    private String name;
    private Person friend;
}
package edu.example;

public class Person {
    public String name;
    public Person mother;
    public Person father;
    public Person friend;

    public Person(String name, Person mother, Person father, Person friend) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.friend = friend;
    }
}

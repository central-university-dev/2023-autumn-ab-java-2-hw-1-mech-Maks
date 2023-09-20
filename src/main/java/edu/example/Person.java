package edu.example;

public class Person {
    private String name;
    private Person mother;
    private Person father;
    private Person friend;

    public Person(String name, Person mother, Person father, Person friend) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.friend = friend;
    }

    @Override
    public String toString() {
        String sep = System.lineSeparator();
        return sep + "name: " + name + sep +
                "mum: " + (mother != null ? mother.getName() : null) + sep +
                "dad: " + (father != null ? father.getName() : null) + sep +
                "friend: " + (friend != null ? friend.getName() : null) + sep;
    }

    public Person(String name) {
        this(name, null, null, null);
    }

    public Person getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public void setMother(Person newMother) {
        mother = newMother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person newFather) {
        father = newFather;
    }

    public Person getFriend() {
        return friend;
    }
}

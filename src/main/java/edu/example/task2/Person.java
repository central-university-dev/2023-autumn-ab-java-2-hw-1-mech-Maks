package edu.example.task2;

public class Person {
    private String name;
    private Person mother;
    private Person father;
    private Person friend;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person mother, Person father, Person friend) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.friend = friend;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person getFriend() {
        return friend;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", mother=" + mother +
                ", father=" + father +
                ", friend=" + friend +
                '}';
    }
}


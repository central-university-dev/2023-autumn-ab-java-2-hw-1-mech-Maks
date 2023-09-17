package edu.secondTask;

public class Person {
    private Person mother;
    private Person father;
    private Person friend;

    public Person(Person mother, Person father, Person friend) {
        this.mother = mother;
        this.father = father;
        this.friend = friend;
    }

    public Person() {

    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }
}

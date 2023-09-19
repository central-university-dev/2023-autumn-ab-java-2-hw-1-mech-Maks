package edu.example;

import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person that = (Person) o;
        return Objects.equals(this.getName(), that.getName()) &&
                Objects.equals(this.getMother(), that.getMother()) &&
                Objects.equals(this.getFather(), that.getFather()) &&
                Objects.equals(this.getFriend(), that.getFriend());
    }
}

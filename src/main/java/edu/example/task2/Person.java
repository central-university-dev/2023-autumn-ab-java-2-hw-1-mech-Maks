package edu.example.task2;

import java.util.Objects;

public class Person {

    private final String name;
    private Person mother;
    private Person father;
    private Person friend;

    public Person(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public String getName() {
        return name;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName())
                && Objects.equals(getMother(), person.getMother())
                && Objects.equals(getFather(), person.getFather())
                && Objects.equals(getFriend(), person.getFriend());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMother(), getFather(), getFriend());
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

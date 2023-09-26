package edu.week01.task2;

public class Person {
    public String name;
    private Person mother = null;
    private Person father = null;

    public Person(String name, Person mother, Person father) {
        this.father = father;
        this.mother = mother;
        this.name = name;
    }

    public Person(String name) {
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

    @Override
    public String toString() {
        return String.format("Person{ name={%s} mother={%s} father={%s} }", name, mother != null ? mother.name : "no", father != null ? father.name : "no");
    }
}

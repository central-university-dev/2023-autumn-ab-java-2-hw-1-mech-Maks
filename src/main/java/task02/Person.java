package task02;

import java.util.List;
import java.util.function.Consumer;

public class Person {
    private String name;
    private Person mother;
    private Person father;
    private Person friend;

    public Person() { }

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

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person getFriend() {
        return friend;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setMother(Person newMother) {
        mother = newMother;
    }

    public void setFather(Person newFather) {
        father = newFather;
    }

    public void setFriend(Person newFriend) {
        friend = newFriend;
    }

    public void executePersonProcessorsChain(List<Consumer<Person>> personProcessorsChain) {
        personProcessorsChain.forEach(personProcessor -> personProcessor.accept(this));
    }
}

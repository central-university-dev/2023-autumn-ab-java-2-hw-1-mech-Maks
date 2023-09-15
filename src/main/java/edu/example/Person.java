package edu.example;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Getter
@Setter
public class Person {
    private Person mother;
    private Person father;
    private Person friend;
    private String name;

    public static void main(String[] args) {
        Person me = new Person("Danya");
        Person mother = new Person("mama");
        Person father = new Person("papa");
        Person friend = new Person("zhenya");
        me.setMother(mother);
        me.setFather(father);
        me.setFriend(friend);

        List<Consumer <Person>> consumers = new ArrayList<>();

        Consumer<Person> change = a -> {
            Person c = a.getMother();
            a.setMother(a.getFather());
            a.setFather(c);
        };
        consumers.add(change);

        Consumer<Person> del = a -> {
            a.setFriend(null);
        };
        consumers.add(del);

        Consumer<Person> log = System.out::println;
        consumers.add(log);

        log.accept(me);

        me.changeMotherWithFather(consumers);
    }

    private Person friendGrandma() {
        return Optional.ofNullable(friend)
                .map(Person::getMother)
                .map(Person::getMother)
                .orElse(null);
    }
    private void changeMotherWithFather(List<Consumer<Person>> consumers) {
        consumers.forEach(a -> a.accept(this));
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "mother=" + Optional.of(this).map(Person::getMother).map(Person::getName).orElse(null) +
                ", father=" + Optional.of(this).map(Person::getFather).map(Person::getName).orElse(null) +
                ", friend=" + Optional.of(this).map(Person::getFriend).map(Person::getName).orElse(null) +
                ", name=" + name;
    }
}
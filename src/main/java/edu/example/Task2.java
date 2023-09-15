package edu.example;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class Task2 {
    public static void main(String[] args) {
        // init
        var me = new Person("Alex");
        var friend = new Person("Steve");
        var myMother = new Person("Julia");
        var myFather = new Person("Jack");
        me.setMother(myMother);
        me.setFather(myFather);
        me.setFriend(friend);

        // handling
        var consumers = createConsumers();
        consumers.forEach(personConsumer -> personConsumer.accept(me));
    }

    @NotNull
    private static List<Consumer<Person>> createConsumers() {
        Consumer<Person> changer = person -> {
            var father = person.getFather();
            person.setFather(person.getMother());
            person.setMother(father);
        };

        Consumer<Person> logger = person -> {
            System.out.println("Parents changed for " + person.toString());
        };

        Consumer<Person> friendRemover = person -> {
            person.setFriend(null);
        };

        return List.of(changer, logger, friendRemover);
    }
}
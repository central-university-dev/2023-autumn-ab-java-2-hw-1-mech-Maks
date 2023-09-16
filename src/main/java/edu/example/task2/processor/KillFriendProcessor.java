package edu.example.task2.processor;

import edu.example.task2.Person;

import java.util.function.Consumer;

public class KillFriendProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        person.setFriend(null);
    }

}

package edu.example.processors;

import edu.example.Person;

import java.util.function.Consumer;

public class RemoveFriendConsumer implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        person.setFriend(null);
    }
}

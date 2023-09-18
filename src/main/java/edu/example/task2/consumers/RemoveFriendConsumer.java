package edu.example.task2.consumers;

import edu.example.task2.Person;

import java.util.function.Consumer;

public class RemoveFriendConsumer implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        person.setFriend(null);
    }
}

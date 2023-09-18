package edu.secondTask.impl.consumers;

import edu.secondTask.Person;

import java.util.function.Consumer;

public class RemoveFriendConsumer implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        person.setFriend(null);
    }
}

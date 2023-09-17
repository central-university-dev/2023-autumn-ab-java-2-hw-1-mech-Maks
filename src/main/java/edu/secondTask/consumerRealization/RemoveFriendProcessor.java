package edu.secondTask.consumerRealization;

import edu.secondTask.Person;

import java.util.function.Consumer;

public class RemoveFriendProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        person.setFriend(null);
    }
}

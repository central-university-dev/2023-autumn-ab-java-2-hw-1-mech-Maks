package edu.secondTask.impl.processors;

import edu.secondTask.Person;
import edu.secondTask.api.PersonProcessor;

public class RemoveFriendProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        person.setFriend(null);
    }
}

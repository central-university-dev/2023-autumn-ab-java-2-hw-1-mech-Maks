package edu.secondTask.processorRealization;

import edu.secondTask.Person;

public class RemoveFriendProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        person.setFriend(null);
    }
}

package edu.example.processors;

import edu.example.Person;
import edu.example.PersonProcessor;

public class RemoveFriendProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        person.setFriend(null);
    }
}

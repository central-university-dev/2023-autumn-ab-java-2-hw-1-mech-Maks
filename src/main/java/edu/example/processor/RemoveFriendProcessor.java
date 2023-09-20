package edu.example.processor;

import edu.example.Person;
import edu.example.PersonProcessor;

import java.util.Optional;

public class RemoveFriendProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        Optional.ofNullable(person).map(p -> {
            p.setFriend(null);
            return p;
        });
    }
}

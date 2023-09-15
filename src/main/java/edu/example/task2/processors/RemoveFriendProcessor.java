package edu.example.task2.processors;


import edu.example.task2.Person;
import edu.example.task2.PersonProcessor;

public class RemoveFriendProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        person.setFriend(null);
    }
}

package edu.example.personstuff.handlers;

import edu.example.personstuff.Person;

public class DeleteFriend implements Handler<Person>{
    @Override
    public void handle(Person person) {
        person.setFriend(null);
    }
}

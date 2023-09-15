package edu.SecondTask.FirstVersion;

import edu.SecondTask.Person;

public class RemoveFriendProcessor implements PersonProcessor {
    @Override
    public void process(Person person) {
        person.setFriend(null);
    }
}

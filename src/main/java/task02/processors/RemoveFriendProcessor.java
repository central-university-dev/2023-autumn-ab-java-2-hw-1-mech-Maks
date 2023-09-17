package task02.processors;

import task02.Person;

import java.util.function.Consumer;

public class RemoveFriendProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        if (person != null) {
            person.setFriend(null);
        }
    }
}

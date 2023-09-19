package homework1.processors;

import homework1.Person;

import java.util.function.Consumer;


public class RemoveFriendProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        person.setFriend(null);
    }
}

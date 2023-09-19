package task2.processors;

import task2.Person;

import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        if (person != null) {
            Person father = person.getFather();
            person.setFather(person.getMother());
            person.setMother(father);
        }
    }
}

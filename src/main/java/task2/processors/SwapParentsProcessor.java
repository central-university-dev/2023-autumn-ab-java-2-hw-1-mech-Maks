package task2.processors;

import task2.Person;

import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        Person tempMother = person.getMother();
        person.setMother(person.getFather());
        person.setFather(tempMother);
    }
}

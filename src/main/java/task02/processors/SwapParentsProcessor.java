package task02.processors;

import task02.Person;

import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {
    @Override
    public void accept(Person person) {
        if (person != null) {
            Person temp = person.getMother();
            person.setMother(person.getFather());
            person.setFather(temp);
        }
    }
}

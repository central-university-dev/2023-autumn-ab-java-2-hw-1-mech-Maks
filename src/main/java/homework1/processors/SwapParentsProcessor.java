package homework1.processors;

import homework1.Person;

import java.util.function.Consumer;

public class SwapParentsProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        Person temp = person.getFather();
        person.setFather(person.getMother());
        person.setMother(temp);
    }
}

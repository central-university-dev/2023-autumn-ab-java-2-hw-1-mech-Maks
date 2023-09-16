package homework1.processors;

import homework1.Person;

import java.util.Optional;
import java.util.function.Consumer;


public class LogProcessor implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        System.out.println("----------------------------");
        System.out.println("-mother is " + person.getMother());
        System.out.println("-father is " + person.getFather());
        System.out.println("-friend is " + person.getFriend());
        System.out.println("----------------------------");
    }
}

package edu.example.task2;

import edu.example.task2.consumers.LogConsumer;
import edu.example.task2.consumers.RemoveFriendConsumer;
import edu.example.task2.consumers.SwapParentsConsumer;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Collection<Person> persons = generatePersons();
        Collection<Consumer<Person>> consumers = List.of(
                new SwapParentsConsumer(),
                new LogConsumer(),
                new RemoveFriendConsumer()
        );

        Collection<Person> modifiedPersons = persons.stream()
                .peek(person -> consumers.forEach(consumer -> consumer.accept(person)))
                .collect(Collectors.toList());
    }

    public static Collection<Person> generatePersons() {
        Person father1 = new Person("John");
        Person mother1 = new Person("Anna");

        Person father2 = new Person("Andy");
        Person mother2 = new Person("Nataly");
        Person friend2 = new Person("Judy");

        Person father3 = new Person("Jason");
        Person mother3 = new Person("Cluadia");
        Person friend3 = new Person("Cirilla");

        return List.of(
                new Person("Tony", mother1, father1, null),
                new Person("Bella", mother2, father2, friend2),
                new Person("Rachel", mother3, father3, friend3)
        );
    }
}

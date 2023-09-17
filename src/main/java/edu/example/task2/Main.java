package edu.example.task2;

import edu.example.task2.processors.FriendDeletingProcessor;
import edu.example.task2.processors.LoggingProcessor;
import edu.example.task2.processors.ParentsSwappingProcessor;

import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Alex");
        Person mother = new Person("Tanya");
        Person father = new Person("Vladimir");
        Person friend = new Person("Zhenya");
        person.setMother(mother);
        person.setFather(father);
        person.setFriend(friend);

        System.out.println("Person before processing: " + person);

        List<Consumer<Person>> processors = List.of(new ParentsSwappingProcessor(), new LoggingProcessor(),
                new FriendDeletingProcessor());

        processors.forEach(p -> p.accept(person));

        System.out.println("Person after processing: " + person);
    }
}

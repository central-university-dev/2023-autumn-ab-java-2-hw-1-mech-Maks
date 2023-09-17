package edu.example;

import edu.example.personstuff.Person;
import edu.example.personstuff.handlers.DeleteFriend;
import edu.example.personstuff.handlers.Handler;
import edu.example.personstuff.chanprocessor.PersonChainProcessor;
import edu.example.personstuff.handlers.ChangeParents;
import edu.example.personstuff.handlers.Logging;

import java.util.List;
import java.util.stream.Stream;

public class app {
    public static void main(String[] args) {

        PersonChainProcessor chainProcessor = new PersonChainProcessor();
        List<Handler<Person>> tasks = Stream.of(
                new ChangeParents(),
                new Logging(),
                new DeleteFriend(),
                new Logging())
                .toList();

        chainProcessor.addHandler(tasks);

        Person mom = new Person("m", null, null, null);
        Person dad = new Person("d", null, null, null);
        Person friend = new Person("f", null, null, null);
        Person person = new Person("c", mom, dad, friend);

        chainProcessor.process(person);
        chainProcessor.process(person);
    }
}
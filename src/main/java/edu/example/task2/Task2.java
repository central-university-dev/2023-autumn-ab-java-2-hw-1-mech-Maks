package edu.example.task2;

import edu.example.task2.processors.LogProcessor;
import edu.example.task2.processors.RemoveFriendProcessor;
import edu.example.task2.processors.SwapParentsProcessor;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Person mom1 = null;
        Person mom2 = new Person("mom2");
        Person mom3 = new Person("mom3");
        Person dad1 = new Person("dad1");
        Person dad2 = new Person("dad2");
        Person dad3 = null;
        Person p1 = new Person("p1");
        Person p2 = new Person("p2");
        Person p3 = new Person("p3");
        p1.setFather(dad1);
        p1.setMother(mom1);
        p2.setFather(dad2);
        p2.setMother(mom2);
        p3.setFather(dad3);
        p3.setMother(mom3);
        var people = List.of(p1, p2, p3);
        var processors = List.of(
                new SwapParentsProcessor(),
                new RemoveFriendProcessor(),
                new LogProcessor()
        );

        process(people, processors);
        System.out.println(people);
        process(p1, processors);
        System.out.println(p1);
    }

    private static void process(List<Person> people, List<PersonProcessor> processors) {
        people.forEach(person -> {
            processors.forEach(personProcessor -> personProcessor.process(person));
        });
    }

    private static void process(Person person, List<PersonProcessor> processors) {
        processors.forEach(personProcessor -> personProcessor.process(person));
    }
}

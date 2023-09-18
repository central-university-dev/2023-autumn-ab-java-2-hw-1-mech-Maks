package edu.secondTask;

import edu.secondTask.impl.processors.LogProcessor;
import edu.secondTask.api.PersonProcessor;
import edu.secondTask.impl.processors.RemoveFriendProcessor;
import edu.secondTask.impl.processors.SwapParentsProcessor;

import java.util.List;

public class Main {
    /*
     * Реализовано два варианта задания для сравнения: с использованием функционального интерфейса Consumer
     * и с использованием кастомного интерфейса PersonProcessor.
     */
    public static void main(String[] args) {
        List<PersonProcessor> processors = List.of(new LogProcessor(),
                new RemoveFriendProcessor(),
                new SwapParentsProcessor());

        Person mother = new Person(),
                father = new Person(),
                friend = new Person();

        List<Person> persons = List.of(new Person(mother, null, friend),
                new Person(mother, father, friend),
                new Person(null, father, friend),
                new Person(mother, father, null));

        processors.forEach(processor -> persons.forEach((processor::process)));
    }
}

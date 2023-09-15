package edu.SecondTask;

import edu.SecondTask.FirstVersion.PersonProcessor;

import java.util.List;

public class Main {
    /*
     * Реализовано два варианта задания для сравнения: с использованием функционального интерфейса Consumer
     * и с использованием кастомного интерфейса PersonProcessor.
     */
    public static void main(String[] args) {
        /* List<Consumer<Person>> consumers = List.of(new edu.SecondTask.SecondVersion.LogProcessor(),
                new edu.SecondTask.SecondVersion.RemoveFriendProcessor(),
                new edu.SecondTask.SecondVersion.SwapParentsProcessor()); */

        List<PersonProcessor> processors = List.of(new edu.SecondTask.FirstVersion.LogProcessor(),
                new edu.SecondTask.FirstVersion.RemoveFriendProcessor(),
                new edu.SecondTask.FirstVersion.SwapParentsProcessor());

        Person mother = new Person(null, null, null),
                father = new Person(null, null, null),
                friend = new Person(null, null, null);

        List<Person> persons = List.of(new Person(mother, null, friend),
                new Person(mother, father, friend),
                new Person(null, father, friend),
                new Person(mother, father, null));

        // consumers.forEach(persons::forEach);
        processors.forEach(processor -> persons.forEach((processor::process)));
    }
}

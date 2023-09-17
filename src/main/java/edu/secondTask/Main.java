package edu.secondTask;

import edu.secondTask.processorRealization.LogProcessor;
import edu.secondTask.processorRealization.PersonProcessor;
import edu.secondTask.processorRealization.RemoveFriendProcessor;
import edu.secondTask.processorRealization.SwapParentsProcessor;

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

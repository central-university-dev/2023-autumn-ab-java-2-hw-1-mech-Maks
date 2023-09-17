package edu.week01.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Functional {
    public static void main(String[] args) {
        Person person1 = new Person("Mother");
        Person person2 = new Person("Father");
        Person person3 = new Person("Child", person1, person2);

        Processor<Person> processor = new PersonProcessor();
        processor.addProcessor(System.out::println);
        processor.addProcessor(person -> person.name = person.name + "1");

        processor.process(person3);

        System.out.println(person3);
    }
}

class Person {
    public String name;
    private Person mother = null;
    private Person father = null;

    public Person(String name, Person mother, Person father) {
        this.father = father;
        this.mother = mother;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public void swapParents() {
        Person temp = this.father;
        this.father = this.mother;
        this.mother = temp;
    }

    @Override
    public String toString() {
        return String.format("Person{ name={%s} mother={%s} father={%s} }", name, mother != null ? mother.name : "no", father != null ? father.name : "no");
    }
}

class Processor<Person> {
    private final List<Consumer<Person>> processors = new ArrayList<>();

    public void addProcessor(Consumer<Person> processor) {
        processors.add(processor);
    }

    public void process(Person person) {
        for (Consumer<Person> processor : processors) {
            processor.accept(person);
        }
    }
}

class PersonProcessor extends Processor<Person> {
    public void swapMotherFather(Person person) {
        person.swapParents();
    }

    @Override
    public void process(Person person) {
        super.process(person);
        swapMotherFather(person);
        System.out.println("changed");
    }
}
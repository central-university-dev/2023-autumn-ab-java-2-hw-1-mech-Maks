package edu.example;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class App {
    public static void main( String[] args ) {
        Person mum1 = new Person("Mum1");
        Person mum2 = new Person("Mum2");
        Person dad1 = new Person("Dad1");
        Person dad2 = new Person("Dad2");

        Collection<Person> people = List.of(
            new Person("Sam",  mum1, dad1, null),
            new Person("Dima", mum1, dad1, null),
            new Person("Bim",  mum2, dad2, null),
            new Person("Bill", mum2, dad2, null)
        );

        System.out.println(people);

        //  some other Person cusumers might be added
        //  during runtime as well (but create Collection using `new` instead of `List.of(...)`, because it `List.of(...)` creates immutable list)
        Collection<Consumer<Person>> handlers = List.of(new ParentSwapper<>());

        people.stream()
                .peek(p -> {
                    handlers.forEach(handler -> handler.accept(p));
                })
                .forEach(p -> {
                    System.out.println("changed");
                });

        System.out.println(people);
    }
}

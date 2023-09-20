package edu.example;

import edu.example.processor.LogProcessor;
import edu.example.processor.RemoveFriendProcessor;
import edu.example.processor.SwapParentsProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        var person = Person.builder()
                .name("Dmitry")
                .mother(Person.builder().name("Dmitry`s mother").build())
                .father(Person.builder().name("Dmitry`s father").build())
                .friend(Person.builder().name("Dmitry`s friend").build())
                .build();


        List<PersonProcessor> chain = new ArrayList<>();

        chain.add(new SwapParentsProcessor());
        chain.add(new LogProcessor());
        chain.add(new RemoveFriendProcessor());

        chain.forEach(it -> it.process(person));
        System.out.println(person);
    }
}

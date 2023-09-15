package edu.example;

import edu.example.processors.LogProcessor;
import edu.example.processors.RemoveFriendProcessor;
import edu.example.processors.SwapParentsProcessor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Task2 {
    public static void main(String[] args) {
        Person maria = new Person();
        maria.setName("Maria");

        Person david = new Person();
        david.setName("David");

        Person jack = new Person();
        jack.setName("Jack");

        Person andrew = new Person("Andrew", maria, david, jack);

//        andrew = Stream.of(andrew)
//                .peek(new LogProcessor())
//                .peek(new RemoveFriendProcessor())
//                .peek(new LogProcessor())
//                .peek(new SwapParentsProcessor())
//                .peek(new LogProcessor()).findFirst().get();

        Queue<Consumer<Person>> chain = new LinkedList<>();

        chain.add(new LogProcessor());
        chain.add(new RemoveFriendProcessor());
        chain.add(new LogProcessor());
        chain.add(new SwapParentsProcessor());
        chain.add(new LogProcessor());


        while (!chain.isEmpty()) chain.poll().accept(andrew);
    }
}

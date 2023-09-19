package edu.example;

import edu.example.processors.LogConsumer;
import edu.example.processors.RemoveFriendConsumer;
import edu.example.processors.SwapParentsConsumer;

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

        Queue<Consumer<Person>> chain = new LinkedList<>();

        chain.add(new LogConsumer());
        chain.add(new RemoveFriendConsumer());
        chain.add(new LogConsumer());
        chain.add(new SwapParentsConsumer());
        chain.add(new LogConsumer());

        chain.forEach(consumer -> consumer.accept(andrew));
    }
}

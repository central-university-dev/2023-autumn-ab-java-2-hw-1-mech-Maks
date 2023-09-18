package edu.example.task2;

import edu.example.task2.processors.LogProcessor;
import edu.example.task2.processors.RemoveFriendProcessor;
import edu.example.task2.processors.SwapParentsProcessor;

import java.util.*;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        // Я не уверен, что правильно понял задание, но получилось что-то такое
        Person mother = new Person("Barbie", null, null, null);
        Person father = new Person("Oppenheimer", null, null, null);
        Person friend = new Person("Ryan Gosling", null, null, null);
        Person person = new Person("Luffy", mother, father, friend);
        List<Consumer<Person>> personProcessors = List.of(new SwapParentsProcessor(), new LogProcessor(),
                new RemoveFriendProcessor(), new LogProcessor(), new SwapParentsProcessor(), new LogProcessor());
        personProcessors.forEach(process -> process.accept(person));
    }
}
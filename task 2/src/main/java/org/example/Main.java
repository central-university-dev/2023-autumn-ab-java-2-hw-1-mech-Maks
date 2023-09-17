package org.example;

import org.example.processors.LogProcessor;
import org.example.processors.RemoveFriendProcessor;
import org.example.processors.SwapParentsProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        List<Function<Person, Person>> functions = new ArrayList<>();

        functions.add(new LogProcessor());
        functions.add(new SwapParentsProcessor());
        functions.add(new RemoveFriendProcessor());

        Person mother = new Person();
        Person father = new Person();

        Person child = new Person();
        Person friend = new Person();
        child.setMother(mother);
        child.setFather(father);
        child.setFriend(friend);

        List<Person> inputList = List.of(child);

        var result = process(inputList, functions);
        System.out.print(result);
    }

    public static List<Person> process(List<Person> persons, List<Function<Person, Person>> functions) {
        List<Person> result = new ArrayList<>();
        for (var person : persons) {
            for (var func : functions) {
                person = func.apply(person);
            }
            result.add(person);
        }
        return result;
    }
}
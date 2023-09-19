package org.example;

import org.example.processors.LogProcessor;
import org.example.processors.PersonProcessor;
import org.example.processors.RemoveFriendProcessor;
import org.example.processors.SwapParentsProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        List<PersonProcessor> functions = new ArrayList<>();

        functions.add(new SwapParentsProcessor());
        functions.add(new RemoveFriendProcessor());
        functions.add(new LogProcessor());

        Person mother = new Person();
        mother.setName("mama");
        Person father = new Person();
        father.setName("father");
        Person child = new Person();
        child.setName("child");
        Person friend = new Person();
        friend.setName("friend");
        child.setMother(mother);
        child.setFather(father);
        child.setFriend(friend);
        friend.setMother(mother);

        List<Person> inputList = List.of(child);
        System.out.println("Before");
        inputList.forEach(System.out::println);

        var result = process(inputList, functions);

        System.out.println("After");
        result.forEach(System.out::println);
        System.out.println();
        System.out.println("child.father == mother: " + (child.getFather() == mother));
        System.out.println("child.mother == father: " + (child.getMother() == father));
        System.out.println("child.friend == null: " + (child.getFriend() == null));

  }

    public static List<Person> process(List<Person> persons, List<PersonProcessor> functions) {
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
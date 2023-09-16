package org.example;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        List<Function<Person, Person>> functions = new ArrayList<>();
        functions.add(Person::swapParents);
        functions.add(Logger::log);

        Person mother = new Person();
        Person father = new Person();

        Person child = new Person();
        child.setMother(mother);
        child.setFather(father);

        List<Person> inputList = List.of(child);

        var result = process(inputList, functions);
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
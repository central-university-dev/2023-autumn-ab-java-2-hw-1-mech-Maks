package org.example;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;


public class MainTest {

    @Test
    public void processTest() {
        List<Function<Person, Person>> functions = new ArrayList<>();
        functions.add(Person::swapParents);
        functions.add(Logger::log);

        Person mother = new Person();
        Person father = new Person();

        Person child = new Person();
        child.setMother(mother);
        child.setFather(father);

        List<Person> inputList = List.of(child);

        List<Person> result = Main.process(inputList, functions);

        assert (result.size() > 0);
        Person people = result.get(0);
        assert(people != null);
        assert(people.getFather() == mother && people.getMother() == father);


    }
}
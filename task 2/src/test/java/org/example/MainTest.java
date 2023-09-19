package org.example;


import org.example.processors.LogProcessor;
import org.example.processors.PersonProcessor;
import org.example.processors.RemoveFriendProcessor;
import org.example.processors.SwapParentsProcessor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;


public class MainTest {

    @Test
    public void processTest() {
        List<PersonProcessor> functions = new ArrayList<>();
        functions.add(new LogProcessor());
        functions.add(new SwapParentsProcessor());
        functions.add(new RemoveFriendProcessor());

        Person mother = new Person();
        Person father = new Person();
        Person friend = new Person();

        Person child = new Person();
        child.setMother(mother);
        child.setFather(father);
        child.setFriend(friend);

        List<Person> inputList = List.of(child);

        List<Person> result = Main.process(inputList, functions);

        assert (result.size() > 0);
        Person people = result.get(0);
        assert(people != null);
        assert(people.getFather() == mother && people.getMother() == father);
        assert (people.getFriend() == null);


    }
}
package edu.example.task2;

import edu.example.task2.App;
import edu.example.task2.Person;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AppTest {

    @Test
    void createPeopleTest() {
        List<Person> people = Stream.of(
                new Person(new Person("Father1"), new Person("Mother1"), new Person("Friend1"), "1"),
                new Person(new Person("Father2"), new Person("Mother2"), new Person("Friend2"), "2")
        ).collect(Collectors.toList());

        List<Person> expected = Stream.of(
                new Person(new Person("Mother1"), new Person("Father1"), null, "1"),
                new Person(new Person("Mother2"), new Person("Father2"), null, "2")
        ).collect(Collectors.toList());
        Collection<Person> actual = App.getModifiedPeople(people, App.getConsumers());
        assertEquals(expected, actual);
    }
}
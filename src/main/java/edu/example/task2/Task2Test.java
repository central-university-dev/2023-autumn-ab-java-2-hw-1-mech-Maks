package edu.example.task2;

import edu.example.task2.processor.KillFriendProcessor;
import edu.example.task2.processor.LogProcessor;
import edu.example.task2.processor.SwapParentsProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task2Test {

    private List<Person> persons;

    @BeforeEach
    void setUp() {
        persons = new ArrayList<>();

        Person alan = new Person();
        alan.setName("Alan");

        Person olga = new Person();
        olga.setName("Olga");

        Person sanya = new Person();
        sanya.setName("Sanya");

        Person chmo = new Person();
        chmo.setName("Chmo");

        alan.setFriend(olga);
        olga.setFriend(sanya);
        sanya.setFriend(chmo);
        chmo.setFriend(alan);

        chmo.setFather(alan);
        chmo.setMother(olga);

        persons.add(alan);
        persons.add(olga);
        persons.add(sanya);
        persons.add(chmo);

    }

    @Test
    void testProcessorsList() {

        List<Consumer<Person>> processors = List.of(
                new LogProcessor(),
                new SwapParentsProcessor(),
                new KillFriendProcessor()
        );

        persons.forEach(
                person -> {
                    processors.forEach(processor -> {
                        processor.accept(person);
                    });
                }
        );

        assertEquals("Olga", persons.get(3).getFather().getName());
        assertEquals("Alan", persons.get(3).getMother().getName());

        persons.forEach(
                person -> {
                    assertNull(person.getFriend());
                }
        );

    }
}

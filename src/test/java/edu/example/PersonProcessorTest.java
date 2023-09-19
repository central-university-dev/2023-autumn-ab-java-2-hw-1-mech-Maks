package edu.example;

import edu.example.processors.LogProcessor;
import edu.example.processors.PersonProcessor;
import edu.example.processors.RemoveFriendProcessor;
import edu.example.processors.SwapParentsProcessor;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonProcessorTest {
    private final List<PersonProcessor> personProcessors = List.of(
            new LogProcessor("Processor started"),
            new RemoveFriendProcessor(),
            new LogProcessor("Friend was removed"),
            new SwapParentsProcessor(),
            new LogProcessor("Parents were swapped")
    );

    private final List<Person> people = List.of(
            new Person(
                    "Bryce",
                    new Person("Martha"),
                    new Person("Thomas"),
                    new Person("Alfred")
            ),
            new Person(
                    "Geralt",
                    new Person("Visenna"),
                    new Person("Korin"),
                    new Person("Dandelion")
            )
    );

    private final List<Person> peopleResult = List.of(
            new Person(
                    "Bryce",
                    new Person("Thomas"),
                    new Person("Martha"),
                    null
            ),
            new Person(
                    "Geralt",
                    new Person("Korin"),
                    new Person("Visenna"),
                    null
            )
    );

    @Test
    public void assertListsHaveTheSameSize() {
        assertEquals(people.size(), peopleResult.size());
    }

    @Test
    public void assertMotherFatherSwappedAndFriendWasRemoved() {
        people.forEach(p -> personProcessors.forEach(f -> f.process(p)));
        assertTrue(
                IntStream.range(0, people.size()).allMatch(
                        i -> Objects.equals(people.get(i), peopleResult.get(i))
                )
        );
    }
}

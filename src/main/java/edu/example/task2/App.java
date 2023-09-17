package edu.example.task2;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {
    public static void main(String[] args) {
        Collection<Person> people = createPeople();
        System.out.println("Before modification:");
        printPeople(people);

        people = getModifiedPeople(people);
        System.out.println("After modification:");
        printPeople(people);
    }


    public static Collection<Person> getModifiedPeople(Collection<Person> people) {
        Consumer<Person> logger = person -> System.out.println("Swap parents for person " + person.getName());
        Consumer<Person> removeFriend = person -> person.setFriend(null);
        Consumer<Person> swapParents = person -> {
            Person father = person.getFather();
            person.setFather(person.getMother());
            person.setMother(father);
        };
        return people.stream()
                // Step 1: Swap parents
                .peek(swapParents)
                // Step 2: Logging changes
                .peek(logger)
                // Step 3: Remove friend
                .peek(removeFriend)
                .collect(Collectors.toList());
    }

    private static Collection<Person> createPeople() {
        Person father1 = new Person("Father1");
        Person mother1 = new Person("Mother1");
        Person friend1 = new Person("Friend1");

        Person father2 = new Person("Father2");
        Person mother2 = new Person("Mother2");
        Person friend2 = new Person("Friend2");

        return Stream.of(
                new Person(father1, mother1, friend1, "person1"),
                new Person(father2, mother2, friend2, "person2")
        ).collect(Collectors.toList());
    }

    private static void printPeople(Collection<Person> people) {
        for (Person person : people)
            System.out.println(String.format("%s has father - %s, mother - %s and friend - %s",
                    person.getName(),
                    Optional.ofNullable(person.getFather()).map(father -> father.getName()).orElse(null),
                    Optional.ofNullable(person.getMother()).map(mother -> mother.getName()).orElse(null),
                    Optional.ofNullable(person.getFriend()).map(friend -> friend.getName()).orElse(null))
            );
    }
}
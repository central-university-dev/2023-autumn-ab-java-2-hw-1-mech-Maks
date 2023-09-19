package edu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Olga"));
        people.add(new Person("Oleg",null, null, people.get(0)));
        people.add(new Person("Maxim", people.get(0), people.get(1), null));  // Son of Oleg and Olga
        people.add(new Person("Maria", people.get(0), people.get(1), people.get(2)));  // Daughter of Oleg and Olga
        System.out.println("Before:");
        printPeople(people);

        people = people.stream().peek(person -> {
            Person temp = person.father;
            person.father = person.mother;
            person.mother = temp;
        }).peek(person -> {
            System.out.println("Changed: Switched parents for person '" + person.name + "'");
        }).peek(person -> {
            person.friend = null;
        }).collect(Collectors.toList());

        System.out.println("After:");
        printPeople(people);
    }

    private static void printPeople(Collection<Person> people) {
        for (Person person : people)
            System.out.println(person);
    }

    private static class Person {

        public Person(String name) {
            this.name = name;
        }

        public Person(String name, Person mother, Person father, Person friend) {
            this.name = name;
            this.mother = mother;
            this.father = father;
            this.friend = friend;
        }

        private final String name;
        private Person mother;
        private Person father;
        private Person friend;

        @Override
        public String toString() {
            return name
                    + ": father - " + (father != null ? father.name : "none")
                    + ", mother - " + (mother != null ? mother.name : "none")
                    + ", friend - " + (friend != null ? friend.name : "none");
        }
    }

}

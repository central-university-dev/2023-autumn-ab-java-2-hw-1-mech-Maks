package edu.example.task4;

import edu.example.task2.Person;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Collection<Person> persons = List.of(
                new Person("John"),
                new Person("Jason"),
                new Person("Alla"),
                new Person("Bill"),
                new Person("Donald")
        );
        caseOne(persons.iterator());
        caseTwo(persons.iterator());
    }

    /* С помощью forEach мы можем пройтись по всем элементам, по всем элементам с условием,
       но не можем пройтись до конкретного элемента в последовательности */
    public static void caseOne(Iterator<Person> iterator) {
        Person father = new Person("Anthony");
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getName().equals("Bill")) {
                break;
            }
            person.setFather(father);
        }
    }

    /* С помощью forEach мы не можем взаимодействовать со следующим
       или предыдущим элементом коллекции */
    public static void caseTwo(Iterator<Person> iterator) {
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (iterator.hasNext()) {
                Person secondPerson = iterator.next();
                swapNames(person, secondPerson);
            }
        }
    }

    public static void swapNames(Person p1, Person p2) {
        String tempName = p1.getName();
        p1.setName(p2.getName());
        p2.setName(tempName);
    }
}

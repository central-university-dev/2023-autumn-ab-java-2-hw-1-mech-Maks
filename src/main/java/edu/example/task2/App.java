package edu.example.task2;

import edu.example.task2.processors.LogProcessor;
import edu.example.task2.processors.RemoveFriendProcessor;
import edu.example.task2.processors.SwapParentsProcessor;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Person person = new Person("Pasha");
        person.setMother(new Person("Masha"));
        person.setFather(new Person("Sergey"));
        person.setFriend(new Person("Artem"));
        System.out.println(person.getFather().getName() + " " + person.getMother().getName());
        System.out.println(person.getFriend().getName());
        List<PersonProcessor> personProcessors = List.of(
                new SwapParentsProcessor(),
                new LogProcessor(),
                new RemoveFriendProcessor()
        );
        personProcessors.forEach(personProcessor -> personProcessor.process(person));
        System.out.println(person.getFriend());
        System.out.println(person.getFather().getName() + " " + person.getMother().getName());

        Person mother1 = new Person("mother1");
        Person mother2 = new Person("mother2");
        Person father1 = new Person("father1");
        Person father2 = new Person("father2");
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        person1.setMother(mother1);
        person1.setFather(father1);
        person2.setMother(mother2);
        person2.setFather(father2);
        List<Person> listPerson = List.of(person1, person2);
        listPerson.forEach(curentPerson -> personProcessors.forEach(personProcessor -> personProcessor
                .process(curentPerson)));
    }
}

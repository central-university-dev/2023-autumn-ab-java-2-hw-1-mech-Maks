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
        System.out.println(person.getFriend().getName());
        List<PersonProcessor> personProcessors = List.of(
                new SwapParentsProcessor(),
                new LogProcessor(),
                new RemoveFriendProcessor()
        );
        personProcessors.forEach(personProcessor -> personProcessor.process(person));
        System.out.println(person.getFriend());
    }
}

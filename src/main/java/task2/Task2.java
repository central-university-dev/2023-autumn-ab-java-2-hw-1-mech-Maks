package task2;

import task2.processors.LogProcessor;
import task2.processors.RemoveFriendProcessor;
import task2.processors.SwapParentsProcessor;

import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        var mother = new Person("Mother", null, null, null);
        var father = new Person("Father", null, null, null);
        var friend = new Person("Friend", null, null, null);
        var person = new Person("Lexa", mother, father, friend);

        Stream.of(new SwapParentsProcessor(), new LogProcessor(), new RemoveFriendProcessor())
                .forEach(processor -> processor.accept(person));
    }
}

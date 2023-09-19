package task2;

import task2.processors.LogProcessor;
import task2.processors.RemoveFriendProcessor;
import task2.processors.SwapParentsProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        Person person = new Person(
                "Коля",
                new Person("Аня"),
                new Person("Ваня"),
                new Person("Даня"));

        List<Consumer<Person>> processors = Arrays.asList(
                new SwapParentsProcessor(),
                new LogProcessor(),
                new RemoveFriendProcessor(),
                new LogProcessor()
        );

        processors.forEach(process -> process.accept(person));
    }
}

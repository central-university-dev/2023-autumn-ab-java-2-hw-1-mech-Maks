package task02;

import task02.processors.LogProcessor;
import task02.processors.RemoveFriendProcessor;
import task02.processors.SwapParentsProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args)
    {
        Person person = new Person(
                "KidName",
                new Person("MotherName"),
                new Person("FatherName"),
                new Person("FriendName")
        );

        List<Consumer<Person>> personProcessors = new ArrayList<>(List.of(
                new RemoveFriendProcessor(),
                new LogProcessor(),
                new SwapParentsProcessor(),
                new LogProcessor()
        ));

        personProcessors.forEach(personProcessor -> personProcessor.accept(person));
    }
}

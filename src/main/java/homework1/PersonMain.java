package homework1;

import homework1.processors.LogProcessor;
import homework1.processors.RemoveFriendProcessor;
import homework1.processors.SwapParentsProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class PersonMain {

    public static void main(String[] args) {
        Person p1 = new Person("John");
        p1.setFriend(new Person("Robert"));
        p1.setMother(new Person("Clare"));
        p1.setFather(new Person("Mike"));

        Consumer<Person> logProcessor = new LogProcessor();
        Consumer<Person> swapParentsProcessor = new SwapParentsProcessor();
        Consumer<Person> removeFriendProcessor = new RemoveFriendProcessor();

        List<Consumer<Person>> processors = new ArrayList<>();
        processors.add(logProcessor);
        processors.add(swapParentsProcessor);
        processors.add(logProcessor);
        processors.add(swapParentsProcessor);
        processors.add(logProcessor);
        processors.add(removeFriendProcessor);
        processors.add(logProcessor);

        processors.forEach(pr -> pr.accept(p1));
    }
}

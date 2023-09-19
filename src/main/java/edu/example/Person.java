package edu.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Getter
@Setter
@ToString
public class Person {
    @Nullable
    private Person mother;
    @Nullable
    private Person father;
    @Nullable
    private Person friend;
    private String name;

    public static void main(String[] args) {
        Person me = new Person("Danya");
        Person mother = new Person("mama");
        Person father = new Person("papa");
        Person friend = new Person("zhenya");
        me.setMother(mother);
        me.setFather(father);
        me.setFriend(friend);

        List<Consumer<Person>> consumers = new ArrayList<>();

        consumers.add(a -> {
            Person c = a.getMother();
            a.setMother(a.getFather());
            a.setFather(c);
        });

        consumers.add(a -> {
            a.setFriend(null);
        });

        consumers.add(a -> System.out.println("Changed mother with father " + me));

        consumers.forEach(a -> a.accept(me));
    }

    public Person(String name) {
        this.name = name;
    }


}
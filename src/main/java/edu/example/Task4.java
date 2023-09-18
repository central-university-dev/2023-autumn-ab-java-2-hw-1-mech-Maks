package edu.example;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
//        example1();
        example2();
//        example3();
    }

    // Во время итерирования по forEach нельзя модифицировать (выпадет ConcurrentModificationException) коллекцию,то есть удалять, добавлять и т.д. элементы.
    // Данный код вызовет исключение ConcurrentModificationException
    public static void example1() {
        var list = new ArrayList<>(List.of("abc", "def", "hgj"));
        list.forEach((s) -> {
            System.out.println(s);
            if (s.equals("def")) {
                list.remove(s); // || list.add(s);
            }
        });
    }
    // При использовании Iterator модифицировать коллекцию можно (но только удалять элементы непосредственно через итератор)
    public static void example2() {
        var list = new ArrayList<>(List.of("abc", "def", "hgj"));
        for (var iterator = list.iterator(); iterator.hasNext();) {
            var s =  iterator.next();
            System.out.println(s);
            if (s.equals("def")) {
                iterator.remove();
            }
        }
    }
    // Но если бы не было вывода внутри цикла, мы смогли бы удалить нужные нам элементу в одну строчку
    public static void example3() {
        var list = new ArrayList<>(List.of("abc", "def", "hgj"));
        System.out.println(list);
        list.removeIf(s -> s.equals("def"));
        System.out.println(list);
    }

    // forEach пройдет все
    public static void example4() {
        var list = List.of("abc", "def", "hgj");
        list.forEach(x -> {
            System.out.println(x);
            // break; no such thing
        });
    }

    // с Iterator можно выйти в какой-то момент
    public static void example5() {
        var list = List.of("abc", "def", "hgj");
        for (var it = list.iterator(); it.hasNext();) {
            var element = it.next();
            System.out.println(element);
            if (element.equals("def")) {
                break;
            }
        }
    }
}

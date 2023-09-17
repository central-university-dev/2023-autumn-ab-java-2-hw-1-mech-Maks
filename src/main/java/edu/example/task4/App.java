package edu.example.task4;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class App {

    public static void main(String[] args) {
        List<Integer> values = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        iteratorRemoveExample(values);
        values = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        forEachRemoveExample(values);

        List<Integer> values1 = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        List<Integer> values2 = IntStream.rangeClosed(5, 10).boxed().collect(Collectors.toList());
        forEachExample(values1, values2);
        iteratorExample(values1, values2);
    }

    //Everything is fine 👍
    public static void forEachExample(List<Integer> values1, List<Integer> values2) {
        int count = 0;
        for (Integer value1 : values1) {
            for (Integer value2 : values2) {
                if (value1 < value2) count++;
            }
        }
    }

    // Example with exception 😭
    public static void iteratorExample(List<Integer> values1, List<Integer> values2) {
        int count = 0;
        try {
            for (Iterator<Integer> itr1 = values1.iterator(); itr1.hasNext(); ) {
                for (Iterator<Integer> itr2 = values2.iterator(); itr2.hasNext(); ) {
                    // Will be exception
                    if (itr1.next() < itr2.next()) {
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("iterator: exception in nested loop");
        }
    }

    // Example with exception 😭
    public static void forEachRemoveExample(List<Integer> values) {
        System.out.println("Example of forEach:");
        try {
            for (Integer integer : values) {
                if (integer % 2 == 0) {
                    // Will be exception
                    values.remove(integer);
                }
            }
        } catch (Exception e) {
            System.out.println("forEach: exception in modification");
        }
        values.stream().forEach(value -> System.out.println(value));
    }

    //Everything is fine👍
    public static void iteratorRemoveExample(List<Integer> values) {
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println("Example of iterator:");
        values.stream().forEach(value -> System.out.println(value));
    }
}

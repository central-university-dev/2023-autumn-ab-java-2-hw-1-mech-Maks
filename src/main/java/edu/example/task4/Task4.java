package edu.example.task4;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        // example 1
        concurrentModificationExample();

        // example 2

        staticArrays();

        // example 3

        nestedLoops();

        // example 4
        breakingWhileIteration();

    }

    private static void concurrentModificationExample() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            numbers.add(i);
        }

        var iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 3) {
                iterator.remove();
            }
        }

        System.out.println("iterator did it");


        // it will fail with Concurrent Modification Exception
        try {
            for (Integer num : numbers) {
                if (num == 2) {
                    numbers.remove(num);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("for each loop failed");
        }
    }

    // but we can't use iterators for arrays. the only way to do this is to use stream of this array
    private static void staticArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }


    // forEach nested loop and nested Iterator will work
    private static void nestedLoops() {
        List<Integer> nums = new LinkedList<>();
        nums.add(2);
        nums.add(3);
        nums.add(4);

        List<Integer> nums2 = new LinkedList<>();
        nums2.add(2);
        nums2.add(4);
        nums2.add(5);
        nums2.add(6);

        for (int num1 : nums) {
            for (int num2 : nums2) {
                if (num1 < num2) {
                    System.out.print(num1 + " ");
                }
            }
        }
        System.out.println();

        List<String> outerList = new ArrayList<>();
        outerList.add("A");
        outerList.add("B");
        outerList.add("C");

        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        innerList.add(2);
        innerList.add(3);

        // Вложенный цикл с использованием итераторов
        Iterator<String> outerIterator = outerList.iterator();
        while (outerIterator.hasNext()) {
            String outerElement = outerIterator.next();
            Iterator<Integer> innerIterator = innerList.iterator();
            while (innerIterator.hasNext()) {
                Integer innerElement = innerIterator.next();
                System.out.println(outerElement + " " + innerElement);
            }
        }
    }

    // using Iterator we can check some conditions and break our loop.
    // but when we use forEach we can't break white iterating.
    private static void breakingWhileIteration() {
        List<String> seasons = new ArrayList<>();
        seasons.add("Winter");
        seasons.add("Spring");
        seasons.add("Summer");
        seasons.add("Fall");

        for (var seasonsIterator = seasons.iterator(); seasonsIterator.hasNext(); ) {
            String current = seasonsIterator.next();
            if (current.equals("Summer")) {
                System.out.println("Vacation yeeey");
                break;
            }
            else {
                System.out.println(current);
            }
        }
        System.out.println();
        seasons.forEach(System.out::println);
    }
}

package edu.example.task4;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        // example 1
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


        // example 2

        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println();

        // but we can't use iterators for arrays. the only way to do this is to use stream of this array


        // example 3

        List<Integer> nums = new LinkedList<>();
        nums.add(2);
        nums.add(3);
        nums.add(4);

        List<Integer> nums2 = new LinkedList<>();
        nums2.add(2);
        nums2.add(4);
        nums2.add(5);
        nums2.add(6);

        // it will work
        for (int num1 : nums) {
            for (int num2 : nums2) {
                if (num1 < num2) {
                    System.out.print(num1 + " ");
                }
            }
        }

        System.out.println("\nnested for each did it");

        try {
            // it will fail because iterator points to next element every time
            for (var iter = nums.iterator(); iter.hasNext(); ) {
                for (var iter2 = nums2.iterator(); iter2.hasNext(); ) {
                    if (iter.next() < iter2.next()) {
                        System.out.println(iter.next() + " ");
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("iterator failed");
        }
    }
}

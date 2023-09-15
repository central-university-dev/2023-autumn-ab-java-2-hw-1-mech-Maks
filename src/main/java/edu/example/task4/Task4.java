package edu.example.task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        // example 1
        List<Integer> numbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        var iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 3) {
                iterator.remove();
            }
        }

        System.out.println("iterator did it");


        // it will fail with Concurrent Modification Exception
        for (Integer num : numbers) {
            if (num == 2) {
                numbers.remove(num);
            }
        }

        System.out.println("for each loop did it");


        // example 2

        int[] arr = new int[] {1,2,3,4,5};
        for (int x : arr) {
            System.out.print(x + " ");
        }

        // but we can't use iterators for arrays. the only way to do this is to use stream of this array


        // example 3

        List<Integer> nums = new LinkedList<>() {{
            add(2);
            add(3);
            add(4);
        }};

        List<Integer> nums2 = new LinkedList<>() {{
            add(2);
            add(4);
            add(5);
            add(6);
        }};

        // it will work
        for (int num1 : nums) {
            for (int num2 : nums2) {
                if (num1 < num2) {
                    System.out.print(num1 + " ");
                }
            }
        }

        // it will fail because iterator points to next element every time
        for (var iter = nums.iterator(); iter.hasNext();) {
            for (var iter2 = nums2.iterator(); iter2.hasNext();) {
                if (iter.next() < iter2.next()) {
                    System.out.println(iter + " ");
                }
            }
        }
    }
}

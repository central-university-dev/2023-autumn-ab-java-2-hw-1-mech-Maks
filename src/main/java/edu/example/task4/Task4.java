package edu.example.task4;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            integerList.add(i);
        }
        System.out.println(integerList);
        //first example
        //it will fall
        try {
            integerList.forEach(integerList::remove);
        } catch (ConcurrentModificationException e) {
            System.out.println("Ошибка");
        }
        System.out.println(integerList);
        //at the same time with iterator you can do it
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (element == 2) {
                iterator.remove(); // Удаление элемента
            }
        }

        System.out.println(integerList);

        //second example
        //The iterator allows you to explicitly control the iteration process and interrupt it if necessary
        List<Integer> integerList2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            integerList2.add(i);
        }


        Iterator<Integer> list = integerList2.iterator();
        while (list.hasNext()) {
            int num = list.next();
            if (num == 2) {
                break;
            }
            System.out.println(num);
        }


        //third example

        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int x : arr) {
            System.out.print(x + " ");
        }

        //it is not possible to use iterators directly for arrays.
        int[] listNumbers = new int[]{2, 3, 4};
        for (int x : listNumbers) {
            System.out.print(x + " ");
        }


    }
}
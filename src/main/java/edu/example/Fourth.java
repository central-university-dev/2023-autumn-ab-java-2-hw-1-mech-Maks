package edu.example;
import java.util.*;

public class Fourth {
    public static void main(String[] args) {
       List<Integer> arr = new ArrayList<>();
       for(int i = 0; i < 11; i++) {
           arr.add(i);
       }


       //first example
        try {
            for (var i:arr) {
                arr.remove(i);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException");
        }


        Iterator<Integer> iterator = arr.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        //second example
        for(int i = 0; i < 11; i++) {
            arr.add(i);
        }

        ListIterator<Integer> iter = arr.listIterator();
        System.out.println(iter.next());
        System.out.println(iter.previous());

        //third example
        try {
            while (true) {
                iter.next();
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException");
        }

        for (var i:arr) {}
        System.out.println("It's ok");
    }
}
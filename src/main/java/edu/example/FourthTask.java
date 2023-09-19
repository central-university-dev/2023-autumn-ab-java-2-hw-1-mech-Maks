package edu.example;
import java.util.*;

public class FourthTask {
    public static void main(String[] args) {
       List<Integer> exampleList = new ArrayList<>();
       for(int i = 0; i < 11; i++) {
           exampleList.add(i);
       }


       //first example
        try {
            exampleList.forEach(exampleList::remove); // пробую изменить коллекцию
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException");
        }

        Iterator<Integer> iterator = exampleList.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();// через итератор коллекция меняется без исключений
        }

        //second example
        for(int i = 0; i < 11; i++) {
            exampleList.add(i);
        }

        ListIterator<Integer> iter = exampleList.listIterator();
        System.out.println(iter.next());// шаг вперед
        System.out.println(iter.previous());// шаг назад


        //third example
        for (var it = exampleList.iterator(); it.hasNext();) {
            System.out.print(it.next());
            //можно написать брейк
        }
        System.out.println();
        exampleList.forEach(System.out::print);
    }
}
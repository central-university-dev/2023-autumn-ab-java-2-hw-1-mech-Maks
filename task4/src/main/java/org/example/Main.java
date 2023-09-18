package org.example;

import lombok.Data;
import lombok.ToString;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) throws InterruptedException {
        caseOne();
        caseTwo();
        caseThree();

    }

    // forEach не может получить доступ к внешним переменым
    static private void caseOne() {
        List<Integer> list = List.of(1, 2, 3, 5);
        Iterator<Integer> iterator = list.listIterator();
        int subSum = 0;
        while (iterator.hasNext()) {
            subSum += iterator.next();
        }

        System.out.println(subSum);
        /* не работает
        int subForeach = 0;
        list.forEach((integer -> subForeach += integer));
         */
    }

    // forEach не может удалить элемент
    static  private void caseTwo() {
        List<Integer> list = List.of(1, 2, 3, 5);
        list = new LinkedList<>(list);
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.print(list);
    }

    // iterator может прикрать итерироваться досрочно
    static private void caseThree() {
        List<Integer> list = List.of(1, 2, 3, 5);
        Iterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext())
            if (iterator.next() == 3) {
                // doSomething
                break;
            }


        list.forEach((elem) -> {
            System.out.println(elem);
            //break; - не работает
        });
    }
    // при всем этом forEach лаконичней
    static private void caseFour() {
        List<Integer> list = List.of(1, 2, 3, 5);
        Iterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
        }

        list.forEach(System.out::println);
    }
}
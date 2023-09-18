package edu.example.task4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 10; ++i) {
            numbers.add(i);
        }
// Возможность удаления элементов через итератор
        for (Iterator<Integer> iter = numbers.iterator(); iter.hasNext(); ) {
            Integer number = iter.next();
            if (number % 2 == 0) {
                iter.remove();
            }
        }
        System.out.println("Удалили четные числа через итератор " + numbers);

        // Ошибка вызывается только после удаления числа, так как структура меняется
        try {
            numbers.forEach(numbers::remove);
        } catch (ConcurrentModificationException e) {
            System.out.println("Я всего лишь хотел пустой массив");
        }
        System.out.println(numbers);


// Возможность остановки

        for (Iterator<Integer> iter = numbers.iterator(); iter.hasNext(); ) {
            Integer number = iter.next();
            if (number == 3) {
                System.out.println("Да, я умею останавливаться");
                break;
            } else {
                System.out.println("bebebe");
            }
        }

        numbers.forEach(number -> {
            if (number == 3) {
                System.out.println("Я не умею останавливаться, памахите");
            }
        });
    }


}


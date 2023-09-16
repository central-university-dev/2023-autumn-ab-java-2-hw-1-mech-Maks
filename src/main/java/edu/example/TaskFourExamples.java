package edu.example;

import java.util.ArrayList;
import java.util.List;

public class TaskFourExamples {
    public static void func() {
        List<Integer> collection = new ArrayList<Integer>();

        collection.add(1);
        collection.add(3);
        collection.add(2);
        collection.add(4);

        // В forEach нельзя сделать break, что часто необходимо
        // А так же нельзя использовать не final переменные, то есть мы не сможем ввести зависимость от какого-нибудь флага,
        // или сохранить какое-то значение в переменную из области видимости вне лямбды

        // Искусственный пример: хотим найти в списке первое число больше данного
        int number = 3;

        int findNum = -1;
        List<Integer> collection2 = new ArrayList<Integer>();

        collection.forEach((x) -> {
            if (x > number) {
                // findNum = x; - ошибка компиляции

                // хотя можно использовать например еще одну коллекцию,
                // но это доп. память в теории размера равного перебираемой коллекции, когда нам надо найти всего одно число
                // а так же не решает проблему, что нам надо перебрать все коллекцию при любом вводе. Нет "удачных случаев"
                collection2.add(x);
            }
        });


        findNum = -1;
        for (int num : collection) {
            if (num > number) {
                findNum = num;
                break;
                // все работает, память на одну переменную, может быть "удачный" случай
            }
        }


        //Так же в forEach нельзя изменять список
        //collection.forEach((x) -> collection.add(x + 1)); -  ConcurrentModificationException


        //Нельзя выкидывать checked exceptions (Проверенные исключения? не уверен в переводе)
        // то есть ошибки можно обработать try-catch, но не получится их обработать через throws
    }
}

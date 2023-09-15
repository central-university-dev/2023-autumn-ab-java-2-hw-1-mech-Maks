package edu.example;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>(List.of(1, 5, 3, 6, 2));

        /*
        Использование итератора иногда является более выгодным за счет возможности concurrent работы над коллекцией
        (одновременные чтение и запись), однако в остальном что iterator, что for-each могут взаимозаменять друг друга.
        В общем, for-each и является итератором под капотом. Сложность с итератором может возникнуть разве что в случае
         неправильного написания цикла
        (если неверно используются next() или hasNext()).
         */

        try {
            for (var x : c)
                if (x == 3) c.remove(x);

            System.out.println(c);
        }
        catch (ConcurrentModificationException e) {
            System.out.println("Выброшено исключение конкурентной модификации коллекции");
            // Причем, число-то удалилось из списка
        }

        // Для примера тот же код, но с применением итератора напрямую

        try {
            for (var it = c.iterator(); it.hasNext(); ) {
                var x = it.next();
                if (x == 6) it.remove();
            }
            System.out.println(c);
        }
        catch (ConcurrentModificationException e) {
            System.out.println("Выброшено исключение конкурентной модификации коллекции");
        }

        List<Integer> v = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        /*
        По следующим 2 примерам видно, что хотя отличия минимальны, немного головной боли может добавить
         */

        for (var it1 = c.iterator(); it1.hasNext(); ) {
            var it1Value = it1.next();
            for (var it2 = v.iterator(); it2.hasNext(); ) {
                System.out.println("Pair (" + it1Value + ", " + it2.next() + ")");
            }
        }

        System.out.println("\n");

        for (var x : c)
            for (var y : v)
                System.out.println("Pair (" + x + ", " + y + ")");
    }
}

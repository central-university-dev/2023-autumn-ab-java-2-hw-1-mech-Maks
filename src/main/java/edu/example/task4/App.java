package edu.example.task4;

import java.util.ArrayList;
import java.util.List;

/**
 * Добавил примеры кейсов, описанные в ответе на edu
 */
public class App {
    public static void main(String[] args) {
        List<Integer> collection1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        // Небольшая опечатка - индекс можно получить с listIterator
        var it = collection1.listIterator();
        while (it.hasNext()) {
            System.out.println("index - " + it.nextIndex() + " val - " + it.next());
        }
        System.out.println("---");

        //  Так же при использовании форыч мы не можем удалять элементы, а с итератором можем (так же и с изменением коллекции)
        List<Integer> collection2 = new ArrayList<>(List.of(10, 20, 34, 50, 44));
        var it2 = collection2.iterator();

        while (it2.hasNext()) {
            if (it2.next() % 5 == 0) {
                it2.remove();
            }
        }

        // Зато forEach позволяет делать такой простой и быстрый вывод
        collection2.forEach(System.out::println);
        System.out.println("---");

        // Можем выйти раньше завершения цикла

        List<Integer> collection3 = new ArrayList<>(List.of(98, 23, -1, 23, 24));
        var it3 = collection3.iterator();
        var isSuccess = true;
        while (it3.hasNext()) {
            if (it3.next() == -1) {
                System.out.println("find -1");
                isSuccess = false;
                break;
            }
        }
        System.out.println(isSuccess ? "Success" : "Error");
    }
}

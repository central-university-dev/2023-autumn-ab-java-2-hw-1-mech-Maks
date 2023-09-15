package edu.FourthTask;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            firstExample();
        } catch (ConcurrentModificationException e) {
            // ignored
        }

        secondExample();

        thirdExample();

        fourthExample();

        fifthExample();
    }

    /*
     * Метод forEach не предоставляет возможности модифицировать коллекцию во время итерации.
     * Если операция требует, к примеру, удаления элемента из коллекции в процессе выполнения,
     * то следует использовать итератор.
     */

    public static void firstExample() {
        List<Integer> exampleCollection = createList(4);

        // Этот метод упадёт с ConcurrentModificationException.

        exampleCollection.forEach(exampleCollection::remove);
    }

    public static void secondExample() {
        List<Integer> exampleCollection = createList(4);

        // Этот метод выполнится нормально.

        Iterator<Integer> iterator = exampleCollection.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    /*
     * Метод forEach выполняет операцию для каждого элемента коллекции последовательно.
     *
     * Итератор позволяет явно контролировать процесс итерации и прервать его при необходимости, если, к примеру,
     * операция требует возможности остановки итерации по определенному условию.
     */

    public static void thirdExample() {
        List<Integer> exampleCollection = createList(4);

        Iterator<Integer> iterator = exampleCollection.iterator();
        while (iterator.hasNext()) {
            int current = iterator.next();

            if (current == exampleCollection.size() - 1) break;

            System.out.print(current);
        }
    }

    /*
     * Метод forEach удобен для простых операций над элементами коллекции,
     * но не в более сложных сценариях, где требуется более тонкое управление и возможность модификации коллекции.
     *
     * Использование forEach() также позволяет сократить количество кода и делает его более читабельным.
     */

    public static void fourthExample() {
        List<Integer> exampleCollection = createList(4);

        exampleCollection.forEach(System.out::print);
    }

    public static void fifthExample() {
        List<Integer> exampleCollection = createList(4);

        Iterator<Integer> iterator = exampleCollection.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next());
    }

    private static List<Integer> createList(int number) {
        List<Integer> exampleCollection = new ArrayList<>();
        for (int i = 0; i < number; i++)
            exampleCollection.add(i);

        return exampleCollection;
    }
}

package task4;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task4 {
    public static void main(String[] args) {
        var collection = IntStream.of(1, 2, 3, 4 ,5)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        removeCase(new ArrayList<>(collection));

        breakCase(collection);

        closureCase(collection);

    }

    //Модификация сурса во время forEach приводит к ConcurrentModificationException
    //А у Iterator'а есть метод remove
    static void removeCase(List<Integer> collection) {
        List<Integer> collectionCopy = new ArrayList<>(collection);

        var iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(collection.size());

        try {
            collectionCopy.forEach(collectionCopy::remove);
        } catch (ConcurrentModificationException e) {
            System.out.println("Так нельзя :(");
        }
    }

    //Нельзя использовать ключевое слово break
    static void breakCase(List<Integer> collection) {
        var iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if (true) // какое-то умное условие
                break;
        }

        collection.forEach(System.out::println);
        //пробежим все елементы
    }

    //Замыкаемая локальная переменная должна быть finall или effectively final
    //Не можем юзать изменяюмую локальную переменную
    static void closureCase(List<Integer> collection) {
        int a = 5;
        a = 4;

        var iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == a) {
                System.out.println("Success");
            }
        }

        /*collection.forEach(num ->  {
            if (num == a) {
                System.out.println("Success");
            }
        });*/
        //Не компилируется
    }
}

package edu.example.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


// Из плюсов - итератор разрешает удалять элементы во время итерации, в отличии от forEach
// Из минусов - итератор не работает с обычными массивами
// forEach - терминальная операция, из него нельзя выйти во время выполнения
// обычный for можно остановить с помощью break
public class Task4Test {

    private final List<Integer> integers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 15; i++) {
            integers.add(i);
        }
    }

    @Test
    void iteratorSuccess() {

        Iterator<Integer> iterator = integers.iterator();
        Exception exception = null;

        try {
            while (iterator.hasNext())
                if (iterator.next() % 2 == 0) iterator.remove();
        } catch (Exception e) {
            System.out.println("Iterator got " + e.getMessage() + "\n");
            exception = e;
        }

        assertNull(exception);

    }

    @Test
    void forEachFailure(){

        Exception exception = null;

        try{
            integers.forEach(
                    integer -> {
                        if (integer % 2 == 0) integers.remove(integer);
                    }
            );
        }catch (Exception e){
            System.out.println("forEach got " + e + "\n");
            exception = e;
        }

        assertEquals(ConcurrentModificationException.class, Optional.ofNullable(exception).map(Exception::getClass).orElse(null));

    }

    @Test
    void stopForEach(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.forEach(
                number -> {
                    // не скомпилится
                    // if (number % 2 == 0 ) break;
                }
        );

    }

    @Test
    void stopFor(){

        int[] numbers = new int[]{1,2,3,4};

        //Тут все будет ок
        for (int number : numbers) {
            if (number % 2 == 0) break;
        }
        //Тут все будет ок
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) break;
        }

    }

}

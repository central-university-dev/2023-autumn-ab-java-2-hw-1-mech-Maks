package edu.example.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


//Из плюсов - итератор разрешает удалять элементы во время итерации, в отличии от forEach
//Из минусов - итератор не работает с обычными массивами
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

}

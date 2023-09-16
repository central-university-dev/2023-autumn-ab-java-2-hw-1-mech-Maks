package org.example;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final AtomicInteger counter = new AtomicInteger(1);


    static public class Incrementer extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10_000;i++)
                counter.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        List<Thread> list = new ArrayList<>();
        for (int i  = 0 ; i < 3;i++) {
            list.add( new Incrementer());
        }

        HashMap
        for (var thread : list) {
            thread.start();
        }

        for (var thread : list) {
            thread.join();
        }

        System.out.print(counter.get());
    }


}
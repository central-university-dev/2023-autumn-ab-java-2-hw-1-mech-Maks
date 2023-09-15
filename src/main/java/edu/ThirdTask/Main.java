package edu.ThirdTask;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        try {
            AtomicInteger integer = new AtomicInteger(1);
            ExecutorService service = Executors.newFixedThreadPool(3);

            List<Callable<Object>> tasks = List.of(Executors.callable(new Incrementor(integer)),
                    Executors.callable(new Incrementor(integer)),
                    Executors.callable(new Incrementor(integer)));

            service.invokeAll(tasks);

            System.out.println(integer.get());

            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

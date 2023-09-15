package edu.example.task3;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    public static void main(String[] args) {
        Variable variable = new Variable();
        Runnable runnable = variable::inc;

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            service.execute(runnable);
        }

        service.shutdown();
        while (!service.isTerminated()) {}

        System.out.println(variable.getX());
    }
}

@Getter
class Variable {
    private int x = 1;
    public synchronized void inc() {
        for (int i = 0; i < 10_000; i++) {
            x += 1;
        }
    }
}

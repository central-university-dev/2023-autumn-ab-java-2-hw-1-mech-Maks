package edu.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
    public static void main(String[] args) {

        var value = new AtomicInteger(1);

        var exec = Executors.newFixedThreadPool(3);
        List<Future<?>> tasks = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            tasks.add(exec.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    value.incrementAndGet();
                }
            }));
        }

        // Проверяем, что все таски выполнены корректно, прежде чем выводить результат
        // (одно лишь ожидание isTerminated не позволит нам этого узнать)

        try {
            for (var t : tasks) {
                t.get();
            }
        } catch (InterruptedException e) {
            System.err.println("Работа потоков была прервана");
            e.printStackTrace();
            return;
        } catch (ExecutionException e) {
            System.err.println("Ошибка при выполнении задачи потока");
            e.printStackTrace();
            return;
        } finally {
            exec.shutdown();
        }

        System.out.println(value.get());
    }
}

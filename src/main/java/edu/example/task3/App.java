package edu.example.task3;

/**
 * Перенёс из отдельного репозитория
 */
public class App {
    private static int counter = 1;

    private static synchronized void incrementCounter() {
        counter++;
    }

    public static void main(String[] args) {
        var th1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementCounter();
            }
        });
        var th2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementCounter();
            }
        });
        var th3 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementCounter();
            }
        });
        th1.start();
        th2.start();
        th3.start();

        // Ждём пока потоки закончатся
        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (Exception e) {
            System.out.println("Threads Error :(");
        }

        System.out.println("Counter value: " + counter);
    }
}

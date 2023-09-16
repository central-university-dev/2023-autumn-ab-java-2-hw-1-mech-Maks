package edu.example;

public class IncrementThread {
    public static int counter = 1;

    public static Void run(int countIteration) {
        for (int i = 0; i < countIteration; i++) {
            synchronized (IncrementThread.class) {
                counter++;
            }
        }
        return null;
    }
}

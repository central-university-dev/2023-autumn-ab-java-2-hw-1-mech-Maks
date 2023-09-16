package homework1;

import java.util.concurrent.*;

public class Incrementer implements Runnable {

    private static int counter = 1;

    @Override
    public void run() {
        int increments = 10000;
        for (int i = 0; i < increments; i++) {
            synchronized (Incrementer.class){
                counter++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int threads = 3;
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            executor.submit(new Incrementer());
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);

        System.out.println("Result: " + counter);
    }
}

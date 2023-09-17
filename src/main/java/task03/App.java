package task03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args)
    {
        int threadsCount = 3;
        int incrementsCount = 10000;

        ExecutorService service = Executors.newFixedThreadPool(threadsCount);
        List<Future> tasks = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            tasks.add(service.submit(new NumberIncrementer(incrementsCount)));
        }

        tasks.forEach(task -> {
            try {
                while (!task.isDone()){
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        service.shutdown();

        System.out.println(NumberIncrementer.getNumber());
    }
}

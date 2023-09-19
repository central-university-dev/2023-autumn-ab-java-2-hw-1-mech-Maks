package edu.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThirdTask {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(1);
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            service.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    counter.incrementAndGet();
                }
            });
        }

        // согласно документации, я завершаю работу ExecutorService в два этапа
        service.shutdown(); // отклонение входящих задач
        try {
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) { // ожидание завершения задач
                service.shutdownNow(); // отмена выполняемых в данный момент задач
                if (!service.awaitTermination(60, TimeUnit.SECONDS)) // ожидание, пока задачи отреагируют на отмену
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ex) {
            service.shutdownNow();
            Thread.currentThread().interrupt(); // сохранить статус прерывания
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(counter.get());
    }
}
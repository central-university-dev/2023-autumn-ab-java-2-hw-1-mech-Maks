package edu.example.task3;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test
{

    @Test
    void testIncrementor(){
        final int poolSize = 3;
        final int result = 30_001;

        Incrementor incrementor = new Incrementor();

        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < poolSize; ++i) {
            executorService.execute(incrementor);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {};

        assertEquals(result, incrementor.getI().get());
        System.out.println("Expected: " + result + "\nGot: " + incrementor.getI() + "\n");

    }

}

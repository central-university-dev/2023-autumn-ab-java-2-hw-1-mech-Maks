package edu.example.task3;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test
{

    @Test
    void testIncrementor(){
        final int POOL_SIZE = 3;
        final int RESULT = 30_001;

        Incrementor incrementor = new Incrementor();

        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; ++i) executorService.execute(incrementor);

        executorService.shutdown();
        while (!executorService.isTerminated());

        assertEquals(RESULT, incrementor.getI());
        System.out.println("Expected: " + RESULT + "\nGot: " + incrementor.getI() + "\n");

    }

}

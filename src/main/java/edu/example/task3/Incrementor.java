package edu.example.task3;

import lombok.Getter;

@Getter
public class Incrementor implements Runnable{

    private int i = 1;

    @Override
    public synchronized void run() {
        for (int j = 0; j < 10_000; ++j) ++i;
    }

}

package edu;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger one = new AtomicInteger(1);
        System.out.println("Initial value: " + one.get());

        List<Incrementor> threads = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            threads.add(new Incrementor(one));
            threads.get(i).start();
        }

        while (threads.stream().anyMatch(incrementor -> !incrementor.isFinished()))
            Thread.sleep(100);

        System.out.println("Final value: " + one.get());
    }

    private static class Incrementor extends Thread {

        Incrementor(AtomicInteger one) {
            this.one = one;
        }

        AtomicInteger one;
        boolean finished = false;

        public boolean isFinished() {
            return finished;
        }

        @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    one.incrementAndGet();
                }
                finished = true;
                interrupt();
            }
        }

}

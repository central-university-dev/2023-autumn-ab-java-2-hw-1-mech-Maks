package task3;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementor implements Runnable {
    public AtomicInteger counter;
    private final int incrementsCount;

    public Incrementor(AtomicInteger startValue, int incrementsCount) {

        counter = startValue;
        this.incrementsCount = incrementsCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementsCount; i++) {
            counter.incrementAndGet();
        }
    }
}

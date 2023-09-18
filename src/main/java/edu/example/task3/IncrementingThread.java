package edu.example.task3;

class IncrementingThread extends Thread {

    private final SharedCounter counter;

    public IncrementingThread(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

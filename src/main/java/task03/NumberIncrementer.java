package task03;

public class NumberIncrementer implements Runnable {
    private static int number = 1;
    private final int incrementsCount;

    public static int getNumber() {
        return number;
    }

    public NumberIncrementer(int incrementsCount) {
        this.incrementsCount = incrementsCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < incrementsCount; i++) {
            synchronized (NumberIncrementer.class) {
                number++;
            }
        }
    }
}

package task3;

public class ConcurrentCounter {
     private int counter = 1;

     public synchronized void increment() {
        counter++;
     }

     public synchronized int get() {
         return counter;
     }
}

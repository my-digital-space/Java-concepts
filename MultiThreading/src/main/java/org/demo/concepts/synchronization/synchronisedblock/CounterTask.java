package org.demo.concepts.synchronization.synchronisedblock;

public class CounterTask implements Runnable {
    private Counter counter;

    public CounterTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment(); // multiple threads will call this method
        }
    }
}

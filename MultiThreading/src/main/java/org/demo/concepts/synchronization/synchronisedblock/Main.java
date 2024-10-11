package org.demo.concepts.synchronization.synchronisedblock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // shared object

        // Create two threads that will access the same Counter object
        Thread t1 = new Thread(new CounterTask(counter), "Thread 1");
        Thread t2 = new Thread(new CounterTask(counter), "Thread 2");

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Print the final count values
        System.out.println("Final Synchronized Count: " + counter.getCount());
        System.out.println("Final Unsynchronized Count: " + counter.getUnsyncedCount());
    }
}

package org.demo.concepts.locks.reentrantLock;

public class Main6 {

    public static void main(String[] args) throws InterruptedException {
        SharedResource6 resourceA = new SharedResource6();
        SharedResource6 resourceB = new SharedResource6();

        // Thread 1 tries to lock resourceA, then resourceB
        Thread thread1 = new Thread(() -> {
                resourceA.method1(resourceB);
            }, "Thread 1");

        // Thread 2 tries to lock resourceB, then resourceA
        Thread thread2 = new Thread(() -> {
                synchronized (resourceA) {
                    resourceB.method1(resourceA);
                }
            }, "Thread 2");

        thread1.start();
        thread2.start();
    }

}

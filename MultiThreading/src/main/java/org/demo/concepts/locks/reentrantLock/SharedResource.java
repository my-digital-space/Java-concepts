package org.demo.concepts.locks.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final Lock lock = new ReentrantLock();

    public void accessResource(String threadName) {
        //if (lock.tryLock()) {
        try {
            if (lock.tryLock(2500, TimeUnit.MILLISECONDS)) {
                try {
                    // Critical section (code that needs synchronization)
                    System.out.println(threadName + " has acquired the lock.");
                    // Simulate some work with the resource
                    Thread.sleep(1000);
                    System.out.println(threadName + " is releasing the lock.");
                } catch (InterruptedException e) {
                    System.out.println(e);
                    Thread.currentThread().interrupt(); // Restore interrupt status
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(threadName + " could not acquire the lock.");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt(); // Restore interrupt status
        }

        // Check if the thread is interrupted
        if (Thread.currentThread().isInterrupted()) {
            System.out.println(threadName + " is marked as interrupted.");
        } else {
            System.out.println(threadName + " is NOT marked as interrupted.");
        }
    }
}

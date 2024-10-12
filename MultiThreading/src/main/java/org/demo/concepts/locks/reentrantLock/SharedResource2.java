package org.demo.concepts.locks.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource2 {
    private final Lock lock = new ReentrantLock();

    public void process() {
        lock.lock();  // First lock
        System.out.println("\n1st Lock acquired.");
        try {
            lock.lock();  // Re-entering (Second lock by the same thread)
            System.out.println("2nd Lock acquired.");
            try {
                // Critical section
                System.out.println("Processing...");
            } finally {
                lock.unlock();  // First unlock (Counter decremented)
                System.out.println("1st Lock released.");
            }
        } finally {
            lock.unlock();  // Second unlock (Counter decremented to zero, lock released)
            // lock.unlock();
            System.out.println("2nd Lock released.");
        }
    }
}

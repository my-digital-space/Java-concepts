package org.demo.concepts.locks.reentrantLock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource3 {
    private final Lock lock = new ReentrantLock();

    // Method using lock() - will block indefinitely
    public void processWithLock() {
        lock.lock();  // Acquires the lock indefinitely, no interruption
        try {
            printWithTimestamp(Thread.currentThread().getName() + " is processing with lock()...");
            // Simulating a long-running task
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 30000) {
                double dummy = Math.sin(Math.random()); // Dummy computation
            }
            printWithTimestamp(Thread.currentThread().getName() + " is done processing with lock()!");
        } catch (Exception e) {
            printWithTimestamp(Thread.currentThread().getName() + " was interrupted.");
        } finally {
            lock.unlock();  // Release the lock
        }
    }

    // Method using lockInterruptibly() - responds to interruptions
    public void processWithLockInterruptibly() {
        try {
            lock.lockInterruptibly();  // Acquires the lock but allows interruption
            try {
                printWithTimestamp(Thread.currentThread().getName() + " is processing with lockInterruptibly()...");
                // Simulating a long-running task
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < 30000) {
                    double dummy = Math.sin(Math.random()); // Dummy computation
                }
                printWithTimestamp(Thread.currentThread().getName() + " is done processing with lockInterruptibly()!");
            } finally {
                lock.unlock();  // Release the lock
            }
        } catch (InterruptedException e) {
            printWithTimestamp(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
        }
    }

    public void printWithTimestamp(String log) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println(LocalDateTime.now().format(formatter) + " " + log);
    }
}

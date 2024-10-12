package org.demo.concepts.locks.reentrantLock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource4 {
    private final Lock lock = new ReentrantLock(true); // fair lock

    public void processWithLock() {
        lock.lock();
        try {
            printWithTimestamp(Thread.currentThread().getName() + " acquired the lock.");
            // Simulating a long-running task
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 1000) { // 1 second task
                double dummy = Math.sin(Math.random()); // Dummy computation
            }
        } catch (Exception e) {
            printWithTimestamp(Thread.currentThread().getName() + " was interrupted.");
        } finally {
            printWithTimestamp(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();  // Release the lock
        }
    }

    public void printWithTimestamp(String log) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println(LocalDateTime.now().format(formatter) + " " + log);
    }
}

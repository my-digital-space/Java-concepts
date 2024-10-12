package org.demo.concepts.locks.reentrantLock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource5 {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    // Read operation: multiple threads can read concurrently
    public int read() {
        readLock.lock();  // Acquire read lock
        try {
            printWithTimestamp(Thread.currentThread().getName() + " reading value: " + count);
            return count;
        } finally {
            readLock.unlock();  // Release read lock
        }
    }

    // Write operation: only one thread can write at a time
    public void write() {
        writeLock.lock();  // Acquire write lock
        try {
            count++;
            printWithTimestamp(Thread.currentThread().getName() + " writing value: " + count);
        } finally {
            writeLock.unlock();  // Release write lock
        }
    }

    public void printWithTimestamp(String log) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println(LocalDateTime.now().format(formatter) + " " + log);
    }
}

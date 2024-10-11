package org.demo.concepts.synchronization.synchronisedblock;

public class Counter {
    private int count = 0;            // Synchronized variable
    private int unsyncedCount = 0;     // Unsynchronized variable

    // Method to increment count with a synchronized block
    public void increment() {
        // Synchronized block to protect the critical section
        synchronized (this) {
            count++; // This variable is thread-safe
        }

        // Unsynchronized access to unsyncedCount
        unsyncedCount++; // This variable is not thread-safe
    }

    public int getCount() {
        return count;
    }

    public int getUnsyncedCount() {
        return unsyncedCount;
    }
}

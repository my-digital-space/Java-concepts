package org.demo.string_immutable1;

public class Main {
    public static void main(String[] args) {
        // Shared immutable string
        final String sharedString = "Hello, Immutable World!";

        // Create several threads that access the shared string concurrently
        Thread thread1 = new Thread(new StringTask(sharedString), "Thread-1");
        Thread thread2 = new Thread(new StringTask(sharedString), "Thread-2");
        Thread thread3 = new Thread(new StringTask(sharedString), "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

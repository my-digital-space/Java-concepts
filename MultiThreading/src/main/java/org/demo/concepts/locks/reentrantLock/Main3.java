package org.demo.concepts.locks.reentrantLock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main3 {

    public static void main(String[] args) throws InterruptedException {
        SharedResource3 sharedResource = new SharedResource3();
//        Thread t1 = new Thread(sharedResource::processWithLock, "Thread 1");
//        Thread t2 = new Thread(sharedResource::processWithLock, "Thread 2");
        Thread t1 = new Thread(sharedResource::processWithLockInterruptibly, "Thread 1");
        Thread t2 = new Thread(sharedResource::processWithLockInterruptibly, "Thread 2");

        printWithTimestamp("Starting " + t1.getName());
        t1.start();
        // Give some time for the first thread to acquire the lock
        Thread.sleep(1000);

        printWithTimestamp("Starting " + t2.getName());
        t2.start();
        // Interrupt the second thread after 2 seconds
        Thread.sleep(2000);
        printWithTimestamp("Attempting to interrupt " + t2.getName() + "...");
        t2.interrupt();  // Interrupting the second thread
    }

    public static void printWithTimestamp(String log) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println(LocalDateTime.now().format(formatter) + " " + log);
    }

}

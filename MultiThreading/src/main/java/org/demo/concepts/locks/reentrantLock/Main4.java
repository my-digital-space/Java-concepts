package org.demo.concepts.locks.reentrantLock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main4 {

    public static void main(String[] args) throws InterruptedException {
        SharedResource4 sharedResource = new SharedResource4();
        Thread t1 = new Thread(sharedResource::processWithLock, "Thread 1");
        Thread t2 = new Thread(sharedResource::processWithLock, "Thread 2");
        Thread t3 = new Thread(sharedResource::processWithLock, "Thread 3");
        Thread t4 = new Thread(sharedResource::processWithLock, "Thread 4");
        Thread t5 = new Thread(sharedResource::processWithLock, "Thread 5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}

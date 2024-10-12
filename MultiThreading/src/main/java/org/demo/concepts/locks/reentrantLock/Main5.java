package org.demo.concepts.locks.reentrantLock;

public class Main5 {

    public static void main(String[] args) throws InterruptedException {
        SharedResource5 sharedResource = new SharedResource5();
        Thread writeThread1 = new Thread(sharedResource::write, "Write Thread 1");
        Thread writeThread2 = new Thread(sharedResource::write, "Write Thread 2");
        Thread readThread1 = new Thread(sharedResource::read, "Read Thread 1");
        Thread readThread2 = new Thread(sharedResource::read, "Read Thread 2");
        Thread readThread3 = new Thread(sharedResource::read, "Read Thread 3");
        Thread readThread4 = new Thread(sharedResource::read, "Read Thread 4");

        writeThread1.start();
        writeThread2.start();
        readThread1.start();
        readThread2.start();
        readThread3.start();
        readThread4.start();
    }

}

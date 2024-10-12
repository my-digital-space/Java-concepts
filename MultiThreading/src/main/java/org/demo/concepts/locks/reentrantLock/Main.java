package org.demo.concepts.locks.reentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        Runnable myTask = new Runnable() {
            @Override
            public void run() {
                resource.accessResource(Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(myTask, "Thread 1");
        Thread t2 = new Thread(myTask, "Thread 2");
        Thread t3 = new Thread(myTask, "Thread 3");

        t1.start();
        Thread.sleep(500);
        t1.interrupt(); // interrupt the Thread 1 after 500 milliseconds
        t2.start();
        t3.start();
    }

}

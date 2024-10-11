package org.demo.basics;

public class DaemonThreadExample extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 7; i++) {
            System.out.println(Thread.currentThread().getName() + " is running, iteration: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        DaemonThreadExample userThread = new DaemonThreadExample();
//        userThread.setName("user-thread");
//        userThread.start(); // This is a normal user thread
//
//        Thread.sleep(2000); // Main thread sleeps for 2 seconds and then finishes
//        System.out.println("Main thread finished.");


        DaemonThreadExample daemonThread = new DaemonThreadExample();
        daemonThread.setName("daemon-thread");
        daemonThread.setDaemon(true); // Mark daemonThread as a daemon thread
        daemonThread.start(); // This is a daemon thread

        Thread.sleep(2000); // Main thread sleeps for 2 seconds and then finishes
        System.out.println("Main thread finished.");
    }
}

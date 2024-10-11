package org.demo.basics;

public class ThreadInterrupt extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread is running... " + i);
                Thread.sleep(1000);  // Pauses the thread for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt thread = new ThreadInterrupt();
        thread.start();  // Start the thread
        Thread.sleep(3000);  // Main thread sleeps for 3 seconds
        thread.interrupt();  // Interrupt the thread after 3 seconds
    }
}

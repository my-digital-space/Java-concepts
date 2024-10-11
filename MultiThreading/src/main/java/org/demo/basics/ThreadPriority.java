package org.demo.basics;

public class ThreadPriority extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " with priority " +
                Thread.currentThread().getPriority() + " is running.");
    }

    public static void main(String[] args) {
        ThreadPriority thread1 = new ThreadPriority();
        ThreadPriority thread2 = new ThreadPriority();
        ThreadPriority thread3 = new ThreadPriority();

        thread1.setPriority(Thread.MIN_PRIORITY);  // Set thread1 to minimum priority
        thread2.setPriority(Thread.NORM_PRIORITY); // Set thread2 to normal priority
        thread3.setPriority(Thread.MAX_PRIORITY);  // Set thread3 to maximum priority

        thread1.start();
        thread2.start();
        thread3.start();
    }


}

package org.demo.basics;

public class ThreadLifecycle extends Thread {
    @Override
    public void run() {
        System.out.println("\n\nThread Name: " + Thread.currentThread().getName() +
                "\nmyThread1 Thread State: RUNNING");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle myThread1 = new ThreadLifecycle();
        System.out.println("Thread Name: " + myThread1.getName() +
                "\nmyThread1 Thread State: " + myThread1.getState() +
                "\nMain Thread State: " + Thread.currentThread().getState());
        myThread1.start();
        System.out.println("\n\nThread Name: " + myThread1.getName() +
                "\nmyThread1 Thread State: " + myThread1.getState() +
                "\nMain Thread State: " + Thread.currentThread().getState());
        Thread.sleep(500);
        System.out.println("\n\nThread Name: " + myThread1.getName() +
                "\nmyThread1 Thread State: " + myThread1.getState() +
                "\nMain Thread State: " + Thread.currentThread().getState());
        myThread1.join();
        System.out.println("\n\nThread Name: " + myThread1.getName() +
                "\nmyThread1 Thread State: " + myThread1.getState() +
                "\nMain Thread State: " + Thread.currentThread().getState());
    }

}

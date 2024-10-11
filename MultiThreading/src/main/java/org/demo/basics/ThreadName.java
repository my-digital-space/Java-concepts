package org.demo.basics;

public class ThreadName extends Thread{

//    public ThreadName(String customThreadName) {
//        super(customThreadName);
//    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadName myThread1 = new ThreadName();
        myThread1.setName("My Thread 1");
        ThreadName myThread2 = new ThreadName();
        myThread2.setName("My Thread 2");

        myThread1.start();
        myThread2.start();
    }
}

package org.demo.createThreads;

public class Main4 {
    public static void main(String[] args) {
//        Runnable myTask = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Current Thread Name: " + Thread.currentThread().getName());
//            }
//        };

//        Runnable myTask = () -> System.out.println("Current Thread Name: " + Thread.currentThread().getName());

        Thread t1 = new Thread(() -> System.out.println("Current Thread Name: " + Thread.currentThread().getName()));
        Thread t2 = new Thread(() -> System.out.println("Current Thread Name: " + Thread.currentThread().getName()));

        t1.start();
        t2.start();
    }
}

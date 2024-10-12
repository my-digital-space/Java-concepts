package org.demo.createThreads;

public class MainMyThread3 {

    public static void main(String[] args) {
        Runnable myTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Current Thread Name: " + Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(myTask);
        Thread t2 = new Thread(myTask);

        t1.start();
        t2.start();
    }

}

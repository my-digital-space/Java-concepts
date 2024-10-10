package org.demo.createThreads;

public class MainMyThread1 {

    public static void main(String[] args) {
        // first we need to create the object of our class MyThread1
//        MyThread1 myThread1 = new MyThread1();
//        myThread1.run();
//        myThread1.start();

//        MyThread1 myThread1 = new MyThread1();
//        MyThread1 myThread2 = new MyThread1();
//        myThread1.start();
//        myThread2.start();

//        for (int i = 1; i <= 3; i++) {
//            MyThread1 myThread = new MyThread1();
//            myThread.start();
//        }
//        throw new RuntimeException();

        for (int i = 1; i <= 3; i++) {
            MyThread1 myThread = new MyThread1();
            myThread.start();
            try {
                myThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("My other code after the threads ...");
    }

}

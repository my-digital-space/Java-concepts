package org.demo.createThreads;

public class MainMyThread2 {

    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        Thread thread = new Thread(myThread);
        thread.start();

    }

}

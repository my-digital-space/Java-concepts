package org.demo.createThreads;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside loop number: " + i + " using Thread: " + Thread.currentThread().getName());

//            if(i==1 && Thread.currentThread().getName().equals("Thread-1")){
//                throw new RuntimeException();
//            }

            try {
                Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

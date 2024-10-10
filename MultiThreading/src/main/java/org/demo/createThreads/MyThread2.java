package org.demo.createThreads;

public class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnable: Inside loop number: " + i + " using Thread: " +
                    Thread.currentThread().getName());

            try {
                Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

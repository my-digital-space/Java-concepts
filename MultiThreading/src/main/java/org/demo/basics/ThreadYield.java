package org.demo.basics;

public class ThreadYield extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " in control");
            Thread.yield(); // Yielding control to give other threads a chance
        }
    }

    public static void main(String[] args) {
        ThreadYield t1 = new ThreadYield();
        ThreadYield t2 = new ThreadYield();

        t1.start();
        t2.start();
    }
}

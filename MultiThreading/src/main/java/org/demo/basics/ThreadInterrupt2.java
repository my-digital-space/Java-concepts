package org.demo.basics;

import java.math.BigInteger;

public class ThreadInterrupt2 extends Thread {
    // Factorial calculation with interruption check
    private long calculateFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            // Check if the thread has been interrupted
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted during calculation!");
                return -1;  // Return a special value indicating interruption
            }
            result = result * i;
        }
        return result;
    }

    @Override
    public void run() {
        System.out.println("Starting factorial calculation...");
        long factorial = calculateFactorial(100000);  // Large number for long calculation
        if (factorial != -1) {
            System.out.println("Factorial calculation completed: " + factorial);
        } else {
            System.out.println("Calculation was interrupted.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt2 thread = new ThreadInterrupt2();
        thread.start(); // Start the thread
        Thread.sleep(500); // Main thread sleeps for 5 seconds
        thread.interrupt(); // Interrupt the thread after 5 seconds
        thread.join();  // Wait for the thread to finish
        System.out.println("Main thread finished.");
    }
}

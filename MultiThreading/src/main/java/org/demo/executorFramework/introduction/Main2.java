package org.demo.executorFramework.introduction;

import java.math.BigInteger;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis(); // Start time in milliseconds
        Thread[] threads = new Thread[10]; // Array to hold threads

        for (int i = 0; i <= 9; i++) {
            final int num = i; // Need final or effectively final for lambda expressions
            threads[i] = new Thread(() -> {
                System.out.println("Factorial of " + num + " is: " + factorial(num));
            });
            threads[i].start(); // Start the thread
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join(); // Wait for each thread to finish
        }

        long duration = System.currentTimeMillis() - startTime; // Time taken in milliseconds
        System.out.println("Time taken: " + duration + " milliseconds (" + (duration / 1000.0) + " seconds)");
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        // to mock some long computation
        try {
            Thread.sleep(1000); // 1-second sleep
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

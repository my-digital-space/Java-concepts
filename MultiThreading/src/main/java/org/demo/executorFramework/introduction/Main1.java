package org.demo.executorFramework.introduction;

import java.math.BigInteger;

public class Main1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Start time in milliseconds

        for (int i = 0; i <= 9; i++) {
            System.out.println("Factorial of " + i + " is: " + factorial(i));
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

package org.demo.executorFramework.introduction;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis(); // Start time in milliseconds

        // Create a fixed thread pool with a certain number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5); // Adjust the pool size as needed

        for (int i = 0; i <= 9; i++) {
            final int num = i;
            executorService.submit(() -> {
                System.out.println("Factorial of " + num + " is: " + factorial(num));
            });
        }

        // Shutdown the executor service after submitting all tasks
        executorService.shutdown();
        // Wait until all tasks are completed or timeout occurs (1 hour timeout just in case)
        // executorService.awaitTermination(1, TimeUnit.HOURS);

        while(!executorService.awaitTermination(1, TimeUnit.MILLISECONDS)){ }

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

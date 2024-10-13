package org.demo.executorFramework.introduction;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main10 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(3000);
            System.out.println("Completed the task!");
            return "Hello World!";
        });
        executorService.shutdown();

        try {
            Thread.sleep(1000); // give some time to start the task
            future.cancel(false);
            System.out.println(future.isCancelled());
            System.out.println(future.isDone());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("All Done! - Main Thread");
    }
}

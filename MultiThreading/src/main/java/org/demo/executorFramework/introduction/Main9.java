package org.demo.executorFramework.introduction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main9 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(3000);
            return "Hello World!";
        });
        executorService.shutdown();

        try {
            String myStr = future.get(2, TimeUnit.SECONDS);
            System.out.println("Result: " + myStr);
        } catch (ExecutionException | TimeoutException e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("All Done! - Main Thread");
    }
}

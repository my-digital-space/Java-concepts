package org.demo.executorFramework.introduction;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(1000);
            return "Hello World!";
        });
        executorService.shutdown();
        System.out.println("isShutdown: " + executorService.isShutdown());
        Thread.sleep(1500);
        System.out.println("isTerminated: " + executorService.isTerminated());
    }
}

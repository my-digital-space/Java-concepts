package org.demo.executorFramework.introduction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main8 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Hello 1");
            return "Hello 1";
        };
        Callable<String> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Hello 2");
            return "Hello 2";
        };
        Callable<String> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Hello 3");
            return "Hello 3";
        };
        List<Callable<String>> myTasksList = Arrays.asList(callable1, callable2, callable3);

        try {
            String response = executorService.invokeAny(myTasksList);
            System.out.println("Result: " + response);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("InterruptedException | ExecutionException");
        }

        executorService.shutdown();
        System.out.println("All Done - Main Thread!");

    }
}

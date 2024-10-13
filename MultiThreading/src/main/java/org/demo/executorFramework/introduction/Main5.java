package org.demo.executorFramework.introduction;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<String> future = executorService.submit(() -> System.out.println("Hello World!"), "Success!!");
        executorService.shutdown();
        System.out.println(future.get());
    }
}

package org.demo.executorFramework.introduction;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //Future<String> future = executorService.submit(() -> "Hello World!");
        Future<?> future = executorService.submit(() -> System.out.println("Hello World!"));
        executorService.shutdown();
//        System.out.println(future.get());
//        if(future.isDone()){
//            System.out.println("Process Done!!");
//        }
       //System.out.println(future.get());
        System.out.println(future.isDone());
    }
}

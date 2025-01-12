package org.demo.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapDemo {
    private static final Map<String, Integer> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {
            for (int i = 0; i < 5; i++) {
                executorService.submit(() -> {
                    for (int j = 0; j < 100; j++) {
                        String key = Thread.currentThread().getName() + j;
                        hashMap.put(key, j);
                    }
                });
            }
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("Final size of HashMap: " + hashMap.size());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

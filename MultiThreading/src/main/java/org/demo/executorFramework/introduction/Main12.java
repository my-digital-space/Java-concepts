package org.demo.executorFramework.introduction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main12 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService schedulerService = Executors.newScheduledThreadPool(1);
        printWithTimestamp("Scheduling the ScheduledExecutorService task");
        schedulerService.scheduleAtFixedRate(
                () -> {
                    printWithTimestamp("Executing the 5 seconds task...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    printWithTimestamp("Task completed after 5 seconds...");
                },
                5,
                10,
                TimeUnit.SECONDS
        );
        Thread.sleep(40000);
        schedulerService.shutdown();
        printWithTimestamp("Done! - Main Thread");
    }

    public static void printWithTimestamp(String log) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println(LocalDateTime.now().format(formatter) + " " + log);
    }
}

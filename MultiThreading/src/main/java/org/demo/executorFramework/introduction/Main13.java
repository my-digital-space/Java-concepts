package org.demo.executorFramework.introduction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main13 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService schedulerService = Executors.newScheduledThreadPool(1);
        printWithTimestamp("Scheduling the ScheduledExecutorService task");

        // Scheduling the task with a fixed delay of 10 seconds
        schedulerService.scheduleWithFixedDelay(
                () -> {
                    printWithTimestamp("Executing the task...");
                    try {
                        // Simulate task taking 5 seconds to complete
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    printWithTimestamp("Task completed.");
                },
                3, // Initial delay of 3 seconds
                10, // Delay of 10 seconds between the end of one task and the start of the next
                TimeUnit.SECONDS
        );

        // Let the main thread wait long enough for the task to execute multiple times
        Thread.sleep(35000); // Wait 35 seconds to observe multiple executions

        schedulerService.shutdown();
        printWithTimestamp("Scheduler Service shutdown.");
    }

    public static void printWithTimestamp(String log) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println(LocalDateTime.now().format(formatter) + " " + log);
    }
}

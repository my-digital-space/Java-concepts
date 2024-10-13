package org.demo.concepts.locks.reentrantLock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource6 {
    // Resource A
    synchronized void method1(SharedResource6 b) {
        System.out.println(Thread.currentThread().getName() + " locked Resource A");

        try { Thread.sleep(100); } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName() + " trying to lock Resource B");
        b.method2();
    }

    // Resource B
    synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " locked Resource B");
    }
}

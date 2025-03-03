package org.demo.singleton;

public class MyCustomSingleton {
    private static volatile MyCustomSingleton instance;

    private MyCustomSingleton() {} // Private constructor prevents instantiation from other classes.

    public static MyCustomSingleton getInstance() {
        if (instance == null) {                         // First check (no locking)
            synchronized (MyCustomSingleton.class) {
                if (instance == null) {                 // Second check (with locking)
                    instance = new MyCustomSingleton();
                }
            }
        }
        return instance;
    }

    public void printHashCode() {
        System.out.println("MyCustomSingleton HashCode: " + this.hashCode());
    }
}

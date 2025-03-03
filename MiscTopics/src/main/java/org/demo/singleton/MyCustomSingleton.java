package org.demo.singleton;

public class MyCustomSingleton {
    private static volatile MyCustomSingleton instance;

    // Private constructor prevents instantiation from other classes.
    private MyCustomSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

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

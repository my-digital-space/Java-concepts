package org.demo.singleton;

import java.io.Serial;
import java.io.Serializable;

public class MyCustomSingleton implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static volatile MyCustomSingleton instance;

    // Private constructor prevents instantiation from other classes.
    private MyCustomSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    @Serial
    private Object readResolve() {
        return getInstance();
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

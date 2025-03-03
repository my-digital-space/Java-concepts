package org.demo.singleton;

public class MyCustomSingleton {
    private static MyCustomSingleton instance;

    private MyCustomSingleton() {} // Private constructor prevents instantiation from other classes.

    public static MyCustomSingleton getInstance() {
        if (instance == null) {
            instance = new MyCustomSingleton();
        }
        return instance;
    }

    public void printHashCode() {
        System.out.println("MyCustomSingleton HashCode: " + this.hashCode());
    }
}

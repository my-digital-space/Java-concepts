package org.demo.singleton;

public class Main {

    public static void main(String[] args) {
        MyCustomSingleton instance1 = MyCustomSingleton.getInstance();
        MyCustomSingleton instance2 = MyCustomSingleton.getInstance();

        instance1.printHashCode();
        instance2.printHashCode();
    }

}

package org.demo.singleton;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) {
        /**
         * Lazy initialized Singleton class
         */
//        MyCustomSingleton instance1 = MyCustomSingleton.getInstance();
//        MyCustomSingleton instance2 = MyCustomSingleton.getInstance();
//        instance1.printHashCode();
//        instance2.printHashCode();

        /**
         * Code to demonstrate that it is not thread safe yet
         */
//        Runnable task = () -> {
//            MyCustomSingleton instance = MyCustomSingleton.getInstance();
//            instance.printHashCode();
//        };
//        Thread thread1 = new Thread(task);
//        Thread thread2 = new Thread(task);
//        thread1.start();
//        thread2.start();

        /**
         * Code to demonstrate how using Reflection we can
         * bypass the private constructor
         */
        MyCustomSingleton instance1 = MyCustomSingleton.getInstance();
        MyCustomSingleton instance2 = null;
        try {
            Constructor<MyCustomSingleton> constructor =
                    MyCustomSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);        // Bypass private access
            instance2 = constructor.newInstance();  // Creates new instance!

            instance1.printHashCode();
            instance2.printHashCode();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}

package org.demo.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) {
        /**
         * Lazy initialized Singleton class
         */
        MyCustomSingleton instance1_1 = MyCustomSingleton.getInstance();
        MyCustomSingleton instance1_2 = MyCustomSingleton.getInstance();
        instance1_1.printHashCode();
        instance1_2.printHashCode();

        /**
         * Code to demonstrate that it is not thread safe yet
         */
        Runnable task = () -> {
            MyCustomSingleton instance2 = MyCustomSingleton.getInstance();
            instance2.printHashCode();
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();

        /**
         * Code to demonstrate how using Reflection we can
         * bypass the private constructor
         */
        MyCustomSingleton instance3_1 = MyCustomSingleton.getInstance();
        MyCustomSingleton instance3_2 = null;
        try {
            Constructor<MyCustomSingleton> constructor =
                    MyCustomSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);        // Bypass private access
            instance3_2 = constructor.newInstance();  // Creates new instance!

            instance3_1.printHashCode();
            instance3_2.printHashCode();
        } catch(Exception e) {
            e.printStackTrace();
        }

        /**
         * Code to demonstrate
         * When a singleton implements Serializable,
         * deserializing it can create a new instance
         */
        try {
            MyCustomSingleton instance4_1 = MyCustomSingleton.getInstance();

            // Serialize to a file.
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            out.writeObject(instance4_1);
            out.close();

            // Deserialize from file.
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
            MyCustomSingleton instance4_2 = (MyCustomSingleton) in.readObject();
            in.close();

            instance4_1.printHashCode();
            instance4_2.printHashCode();
        } catch(Exception e) {
            e.printStackTrace();
        }

        /**
         * Code to demonstrate
         * how cloning can create a new instance
         */
        try {
            MyCustomSingleton instance5_1 = MyCustomSingleton.getInstance();
            MyCustomSingleton instance5_2 = instance5_1.clone();
            instance5_1.printHashCode();
            instance5_2.printHashCode();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}

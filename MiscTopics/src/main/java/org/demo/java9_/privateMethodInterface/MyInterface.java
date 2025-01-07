package org.demo.java9_.privateMethodInterface;

public interface MyInterface {
    /**
     * Interface Variables:
     * Key Points to Remember
     * 1. Interface Variables:
     *      Variables in interfaces are always "public static final".
     *      They are constants and cannot be changed.
     *
     * 2. Instance Variables
     *      Interfaces cannot have instance variables because they cannot store state.
     *      Instance variables belong to implementing classes.
     *
     * 3. Default and Static Methods
     *      Default methods can use interface constants and interact with implementing class variables indirectly.
     *      Static methods can only use constants from the interface.
     */

    // Constants (implicitly public, static, and final)
    int MAX_VALUE = 100;
    String GREETING = "Hello, Interface!";

    // Abstract method (implicitly public and abstract)
    // Must be implemented by any class that implements the interface.
    void myMethod1();

    // Abstract method (implicitly public and abstract)
    // Must be implemented by any class that implements the interface.
    int myMethod2();

    // Default method (provides default implementation)
    // Can be overridden in the implementing class. (Optional)
    default void myMethod3() {
        System.out.println("Default method: myMethod3" + GREETING);
    }

    // Static method (belongs to the interface, accessed via interface name)
    // Cannot be overridden in implementing classes.
    static void myStaticMethod() {
        System.out.println("Static method: myStaticMethod" + GREETING);
    }

    // Private method (helper for default methods, introduced in Java 9)
    // Used to encapsulate shared logic among default methods.
    // Cannot be accessed or overridden by implementing classes.
    private void myPrivateHelper() {
        System.out.println("Private helper method" + GREETING);
    }

    // Default method using a private method
    default void myMethod4() {
        System.out.println("Calling private helper from default method: myMethod4" + GREETING);
        myPrivateHelper();
    }

    // Private static method (helper for static methods, introduced in Java 9)
    // Used to encapsulate shared logic among default methods.
    // Cannot be accessed or overridden by implementing classes.
    private static void myPrivateStaticHelper() {
        System.out.println("Private static helper method" + GREETING);
    }

    // Static method using a private static method
    static void myStaticMethod2() {
        System.out.println("Calling private static helper from static method: myStaticMethod2" + GREETING);
        myPrivateStaticHelper();
        // myPrivateHelper(); // this will throw error as this is not static
    }

}

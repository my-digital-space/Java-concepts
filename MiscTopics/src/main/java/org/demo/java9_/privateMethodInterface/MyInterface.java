package org.demo.java9_.privateMethodInterface;

public interface MyInterface {

    // Abstract method (implicitly public and abstract)
    // Must be implemented by any class that implements the interface.
    void myMethod1();

    // Abstract method (implicitly public and abstract)
    // Must be implemented by any class that implements the interface.
    int myMethod2();

    // Default method (provides default implementation)
    // Can be overridden in the implementing class. (Optional)
    default void myMethod3() {
        System.out.println("Default method: myMethod3");
    }

    // Static method (belongs to the interface, accessed via interface name)
    // Cannot be overridden in implementing classes.
    static void myStaticMethod() {
        System.out.println("Static method: myStaticMethod");
    }

    // Private method (helper for default methods, introduced in Java 9)
    // Used to encapsulate shared logic among default methods.
    // Cannot be accessed or overridden by implementing classes.
    private void myPrivateHelper() {
        System.out.println("Private helper method");
    }

    // Default method using a private method
    default void myMethod4() {
        System.out.println("Calling private helper from default method: myMethod4");
        myPrivateHelper();
    }

    // Private static method (helper for static methods, introduced in Java 9)
    // Used to encapsulate shared logic among default methods.
    // Cannot be accessed or overridden by implementing classes.
    private static void myPrivateStaticHelper() {
        System.out.println("Private static helper method");
    }

    // Static method using a private static method
    static void myStaticMethod2() {
        System.out.println("Calling private static helper from static method: myStaticMethod2");
        myPrivateStaticHelper();
        // myPrivateHelper(); // this will throw error as this is not static
    }

}

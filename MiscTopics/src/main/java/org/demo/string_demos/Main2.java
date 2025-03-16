package org.demo.string_demos;

public class Main2 {

    public static void main(String[] args) {
        // compare1();
        // compare2();
        compare3();
    }

    public static void compare1() {
        String a = new String("Hello");
        String b = new String("Hello");

        // Using '==': compares memory addresses, so this is false
        System.out.println(a == b); // Output: false

        // Using '.equals()': compares the content of the strings, so this is true
        System.out.println(a.equals(b)); // Output: true
    }

    public static void compare2() {
        String a = "Hello";
        String b = "Hello";

        // Using '==': compares memory addresses
        System.out.println(a == b); // Output: true

        // Using '.equals()': compares the content
        System.out.println(a.equals(b)); // Output: true
    }

    public static void compare3() {
        String a = new String("Hello");
        String b = "Hello";

        // Using '==': compares memory addresses
        System.out.println(a == b); // Output: false

        // Using '.equals()': compares the content
        System.out.println(a.equals(b)); // Output: true
    }

}

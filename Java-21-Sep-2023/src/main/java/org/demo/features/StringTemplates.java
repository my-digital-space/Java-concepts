package org.demo.features;

import static java.lang.StringTemplate.STR;

public class StringTemplates {
    public static void main(String[] args) {
        String name = "Rahul";
        int age = 28;

        // Using a string template
        String message = STR."Hello, \{name}. You are \{age} years old.";
        //System.out.println(message);

        String multilineMessage = STR."""
                    Dear \{name},
                    Welcome to our platform.
                    Age: \{age}
                """;
        System.out.println(multilineMessage);
    }
}



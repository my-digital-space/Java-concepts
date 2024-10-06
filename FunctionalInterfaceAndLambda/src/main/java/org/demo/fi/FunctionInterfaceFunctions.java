package org.demo.fi;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class FunctionInterfaceFunctions {

    public static void main(String[] args) {
//        Consumer<String> print = (s) -> System.out.println(s);
//        // Use the Consumer to print a string
//        print.accept("Hello, Lambda!");

//        // Define a BiConsumer that takes a String and an Integer
//        BiConsumer<String, Integer> printInfo = (name, age) ->
//                System.out.println(name + " is " + age + " years old.");
//        // Use the BiConsumer with specific values
//        printInfo.accept("John", 30);

//        // Define a Predicate to check if a number is even
//        Predicate<Integer> isEven = (n) -> n % 2 == 0;
//        // Test the Predicate with some values
//        System.out.println(isEven.test(4));  // Output: true
//        System.out.println(isEven.test(7));  // Output: false

//        // Define a BiPredicate to check if a string has a specified length
//        BiPredicate<String, Integer> hasLength = (str, len) -> str.length() == len;
//        // Test the BiPredicate with some values
//        System.out.println(hasLength.test("hello", 5));  // Output: true
//        System.out.println(hasLength.test("world", 3));  // Output: false

//        // Define a Function that converts an Integer to a String
//        Function<Integer, String> intToString = (num) -> "Number: " + num;
//        // Test the Function with an integer
//        String result = intToString.apply(5);
//        System.out.println(result);  // Output: Number: 5

//        // Define a BiFunction to add two Integers and return a String
//        BiFunction<Integer, Integer, String> addAndConvertToString = (a, b) -> "Sum: " + (a + b);
//        // Test the BiFunction with two integers
//        String result = addAndConvertToString.apply(5, 10);
//        System.out.println(result);  // Output: Sum: 15

//        // Define a UnaryOperator to double a number
//        UnaryOperator<Integer> doubleValue = (n) -> n * 2;
//        // Test the UnaryOperator with a value
//        Integer result = doubleValue.apply(5);
//        System.out.println("Doubled Value: " + result);  // Output: Doubled Value: 10

//        // Define a BinaryOperator to find the maximum of two numbers
//        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
//        // Test the BinaryOperator with two values
//        Integer result = max.apply(10, 20);
//        System.out.println("Maximum Value: " + result);  // Output: Maximum Value: 20

//        // Define a Supplier for random numbers
//        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
//        // Use Stream.generate with the Supplier to produce random numbers
//        Stream.generate(randomNumberSupplier)
//                .limit(5)  // Limit to the first 5 random numbers
//                .forEach(System.out::println);

        // Define a Supplier for the Fibonacci sequence
        Supplier<int[]> fibonacciSupplier = new Supplier<>() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int[] get() {
                int[] result = { previous, current };
                int nextValue = previous + current;
                previous = current;
                current = nextValue;
                return result;
            }
        };

        // Use Stream.generate with the Supplier to produce Fibonacci numbers
        Stream.generate(fibonacciSupplier)
                .map(n -> n[0])  // Extract only the current number in the pair
                .limit(10)        // Limit to the first 10 Fibonacci numbers
                .forEach(System.out::println);  // Output: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        

    }

}

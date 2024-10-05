package org.demo.optional;

import org.demo.util.Employee;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

public class OptionalMethods {
    // Metric to track how many times an empty Optional was encountered
    private static int emptyOptionalCount = 0;

    public static void main(String[] args) {
        Optional<Employee> optionalEmployee = findEmployeeByIdOptional(1);

        //System.out.println(getMyValue().get());
        //getMyValue().ifPresent(System.out::println);
        //System.out.println(getMyValue().isEmpty());
        // System.out.println(getMyValue().get());
        //System.out.println(optionalEmployee.isPresent());
        //System.out.println(getMyValue().orElse("my default value"));
        // System.out.println(getMyValue().orElseGet(() -> "my default value 2"));

//        String myText = "Hello World";
//
//        String opt1 = Optional.ofNullable(myText).orElse(myDefaultFunctionCall());
//        System.out.println("opt1: " + opt1);
//
//        String opt2 = Optional.ofNullable(myText).orElseGet(() -> myDefaultFunctionCall());
//        System.out.println("opt2: " + opt2);

//        String myText = null;
//        String opt1 = Optional.ofNullable(myText).orElseThrow(IllegalArgumentException::new);
//        String opt1 = Optional.ofNullable(myText).orElseThrow();
//        System.out.println("opt1: " + opt1);

//        String myText = "Hello";
//        boolean isHello1 = Optional.of(myText).filter(myStr -> myStr.equals("Hello")).isPresent();
//        System.out.println("isHello1: " + isHello1);
//        boolean isHello2 = Optional.of(myText).filter(myStr -> myStr.equals("Hello world")).isPresent();
//        System.out.println("isHello2: " + isHello2);


//        // Example password (can be empty, null, or a valid password)
//        Optional<String> passwordInput = Optional.of("   mySecret123   ");
//        // Check if password is valid
//        Optional<String> validPassword = passwordInput
//                .map(String::trim) // Trim the password
//                .filter(password -> password.length() >= 8) // Check if password has at least 8 characters
//                .filter(password -> password.matches(".*\\d.*")) // Check if password contains at least one digit
//                .filter(password -> password.matches(".*[a-zA-Z].*")); // Check if password contains at least one letter
//        // Output the result
//        validPassword.ifPresentOrElse(
//                password -> System.out.println("Valid password: " + password),
//                () -> System.out.println("Invalid password"));

//        // An empty Optional
//        Optional<String> optionalEmpty = Optional.empty();
//        // Using or() to provide an alternative Optional if the value is empty
//        Optional<String> optionalWithDefault = optionalEmpty.or(() -> Optional.of("Default Value"));
//        // Print the value, which will be the default since the original is empty
//        System.out.println("Result: " + optionalWithDefault.orElse("No Value"));

//        // Example with an empty Optional
//        Optional<String> emptyOptional = Optional.empty();
//        // Process the empty Optional
//        emptyOptional.ifPresentOrElse(
//                value -> processValue(value),        // Won't be executed
//                () -> logEmptyOptional()             // This will be executed
//        );
//        // Output the metric count of empty Optionals encountered
//        System.out.println("Empty Optionals encountered: " + emptyOptionalCount);

        //Optional<String> optionalName = Optional.of("John");
//        Optional<String> optionalName = Optional.empty();
//        List<String> nameList = optionalName.stream()
//                .map(String::toUpperCase)  // Convert to uppercase
//                .collect(Collectors.toList());
//
//        System.out.println("Uppercase name list from non-empty Optional: " + nameList);



    }

    // Method where one parameter is Optional (misuse)
    public static void processUser(String name, Optional<String> email) {
        // Processing the user
        System.out.println("Processing user: " + name);

        // Checking if email is present
        if (email.isPresent()) {
            System.out.println("Email: " + email.get());
        } else {
            System.out.println("No email provided");
        }
    }

    private static void processValue(String value) {
        System.out.println("Processing value: " + value);
    }

    private static void logEmptyOptional() {
        System.out.println("Optional is empty!");
        emptyOptionalCount++;  // Increment the metric
    }

    public static String myDefaultFunctionCall() {
        System.out.println("inside myDefaultFunctionCall()...");
        return "my default value 3";
    }

    public static boolean ageInRange(Employee employee) {
        return Optional.ofNullable(employee)
                .map(Employee::getAge)
                .filter(age -> age >= 18)
                .filter(age -> age <= 60)
                .isPresent();
    }

    public static Optional<String> getMyValue() {
        String myVar = "Hello World";
        return Optional.ofNullable(myVar);
    }

    public static Optional<Employee> findEmployeeByIdOptional(int id) {
        Employee employee = new Employee(
                1, "Name 1", "HR Department",
                BigDecimal.valueOf(100.00), 30);
        return Optional.ofNullable(employee);
    }




}

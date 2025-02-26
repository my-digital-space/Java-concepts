package org.demo.shallow_vs_deep_copy;

public class ShallowCopyExample {
    public static void main(String[] args) {
        Person person = new Person("John", 30);
        Employee original = new Employee(person, "E123");

        // Shallow copy: reusing the same Person reference
        Employee shallowCopy = new Employee(original.person, original.employeeId);

        // Modify the shallow copy
        shallowCopy.person.name = "Jane";
        // Check the original
        System.out.println("Original person's name: " + original.person.name); // Outputs "Jane"
        System.out.println("Shallow copy person's name: " + shallowCopy.person.name); // Outputs "Jane"


        original.employeeId = "X101";
        System.out.println("Original Employee ID: " + original.employeeId); // Outputs "X101"
        System.out.println("Shallow copy Employee ID: " + shallowCopy.employeeId); // Outputs "E123"
    }
}

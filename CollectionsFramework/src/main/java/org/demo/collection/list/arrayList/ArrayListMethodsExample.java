package org.demo.collection.list.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethodsExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        // 1. Adding Elements
        names.add("Aarav");
        names.add("Vivaan");
        names.add("Siya");

        // 2. Inserting at Specific Position
        names.add(1, "Rohan");

        // 3. Accessing Elements
        System.out.println("Element at index 2: " + names.get(2));

        // 4. Checking for an Element
        System.out.println("Contains 'Siya': " + names.contains("Siya"));

        // 5. Changing an Element
        names.set(2, "Anika");

        // 6. Removing Elements
        names.remove("Vivaan"); // by value
        names.remove(0); // by index

        // 7. Iterating Elements
        System.out.println("Current List:");
        for (String name : names) {
            System.out.println(name);
        }

        // 8. Getting Size
        System.out.println("List Size: " + names.size());

        // 9. Checking if Empty
        System.out.println("Is list empty? " + names.isEmpty());

        // 10. Clearing the List
        names.clear();
        System.out.println("List after clearing: " + names);
    }
}

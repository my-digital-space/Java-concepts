package org.demo.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // 1. Creating a List and Adding Elements
        List<String> names = new ArrayList<>();
        names.add("Aarav");
        names.add("Vivaan");
        names.add("Siya");
        names.add("Anika");
        System.out.println("List after adding elements: " + names);

        // 2. Changing Elements
        names.set(1, "Rohan"); // Changing element at index 1 to "Rohan"
        System.out.println("List after changing an element: " + names);

        // 3. Removing Elements
        names.remove("Siya"); // Removing "Siya" from the list
        System.out.println("List after removing an element: " + names);

        // 4. Iterating the List
        System.out.println("Iterating over the list:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}

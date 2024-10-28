package org.demo.collection.list.linkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        // Creating a LinkedList
        List<String> names = new LinkedList<>();

        // Adding elements to the LinkedList
        names.add("Amit");               // Adding at the end
        names.addFirst("Ravi");           // Adding at the beginning
        names.addLast("Vijay");           // Adding at the end
        names.add(2, "Suman");            // Adding at a specific index
        System.out.println("\nAfter adding elements: " + names);

        // Accessing elements
        System.out.println("First Element: " + names.getFirst());   // Get the first element
        System.out.println("Last Element: " + names.getLast());     // Get the last element
        System.out.println("Element at index 2: " + names.get(2));  // Get element by index

        // Updating an element
        names.set(2, "Anjali");  // Set a new value at index 2
        System.out.println("\nAfter updating index 2: " + names);

        // Removing elements
        names.removeFirst();  // Remove the first element
        names.removeLast();   // Remove the last element
        names.remove(1);      // Remove element at index 1
        System.out.println("\nAfter removing elements: " + names);

        // Check if the LinkedList contains an element
        System.out.println("Contains 'Amit': " + names.contains("Amit"));
        System.out.println("Contains 'Suman': " + names.contains("Suman"));

        // Checking size
        System.out.println("\nSize of LinkedList: " + names.size());

        // Iterating through the LinkedList
        System.out.print("\nElements: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // Clearing the LinkedList
        names.clear();
        System.out.println("\nAfter clearing, LinkedList is empty: " + names.isEmpty());
    }
}

package org.demo.collection.list.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListConstructorsExample {
    public static void main(String[] args) {
        // 1. ArrayList(): Creates an empty ArrayList with default capacity of 10
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        System.out.println("ArrayList() - Default Capacity: " + list1);

        // 2. ArrayList(Collection c): Creates an ArrayList containing elements of the specified collection
        List<String> initialList = Arrays.asList("Cat", "Dog", "Elephant");
        ArrayList<String> list2 = new ArrayList<>(initialList);
        System.out.println("ArrayList(Collection c): " + list2);

        // 3. ArrayList(int capacity): Creates an empty ArrayList with specified initial capacity
        ArrayList<String> list3 = new ArrayList<>(5);
        list3.add("Orange");
        list3.add("Grapes");
        System.out.println("ArrayList(int capacity): " + list3);
    }
}

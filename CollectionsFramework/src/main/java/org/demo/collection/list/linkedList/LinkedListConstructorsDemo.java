package org.demo.collection.list.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListConstructorsDemo {
    public static void main(String[] args) {
        // 1. Using LinkedList() - Creates an empty LinkedList
        List<String> emptyList = new LinkedList<>();
        System.out.println("Empty LinkedList: " + emptyList);

        // Adding some elements to emptyList
        emptyList.add("Apple");
        emptyList.add("Banana");
        emptyList.add("Cherry");
        System.out.println("LinkedList after adding elements: " + emptyList);

        // 2. Using LinkedList(Collection<? extends E> c) - Initializes with another collection
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Mango");
        arrayList.add("Orange");
        arrayList.add("Pineapple");

        LinkedList<String> initializedList = new LinkedList<>(arrayList);
        System.out.println("LinkedList initialized with ArrayList: " + initializedList);
    }
}

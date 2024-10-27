package org.demo.collection.introduction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Amit");
        names.add("Sita");
        names.add("Rahul");
        names.add("Priya");

        // 1. Using Enhanced For Loop (for-each loop)
        System.out.println("Using enhanced for loop:");
        for (String name : names) {
            System.out.println(name);
        }

        // 2. Using Iterable forEach() method with lambda
        System.out.println("\nUsing Iterable forEach loop:");
        names.forEach(name -> System.out.println(name));

        // 3. Using Iterator<T> interface
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

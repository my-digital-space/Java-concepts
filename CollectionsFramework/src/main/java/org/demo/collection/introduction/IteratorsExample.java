package org.demo.collection.introduction;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Vector;

public class IteratorsExample {
    public static void main(String[] args) {
        // Sample list for Iterator, ListIterator, and Spliterator
        List<String> names = new ArrayList<>();
        names.add("Amit");
        names.add("Sita");
        names.add("Rahul");
        names.add("Priya");

        // 1. Using Iterator
        System.out.println("Using Iterator:");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 2. Using ListIterator
        System.out.println("\nUsing ListIterator (forward traversal):");
        ListIterator<String> listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("\nUsing ListIterator (backward traversal):");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // 3. Using Spliterator
        System.out.println("\nUsing Spliterator:");
        Spliterator<String> spliterator = names.spliterator();
        spliterator.forEachRemaining(System.out::println);

        // Sample vector for Enumeration
        Vector<String> vector = new Vector<>(names);

        // 4. Using Enumeration
        System.out.println("\nUsing Enumeration:");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}

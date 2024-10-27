package org.demo.collection.introduction.customDS;

import java.util.Iterator;

public class MyList implements Iterable<Integer> {
    private Integer[] elements;
    private int size;

    // Constructor
    public MyList(int capacity) {
        elements = new Integer[capacity];
        size = 0;
    }

    // Add method
    public void add(Integer element) {
        if (size < elements.length) {
            elements[size++] = element;
        } else {
            System.out.println("List is full");
        }
    }

    // Overriding iterator() method
    @Override
    public Iterator<Integer> iterator() {
        return new MyListIterator();
    }

    // Inner class implementing Iterator interface
    private class MyListIterator implements Iterator<Integer> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Integer next() {
            return elements[currentIndex++];
        }
    }
}


package org.demo.collection.introduction.customDS;

public class Main {
    public static void main(String[] args) {
        MyList myList = new MyList(5);
        myList.add(10);
        myList.add(20);
        myList.add(30);

        // Using the enhanced for-loop to iterate
        for (Integer element : myList) {
            System.out.println(element);
        }
    }
}

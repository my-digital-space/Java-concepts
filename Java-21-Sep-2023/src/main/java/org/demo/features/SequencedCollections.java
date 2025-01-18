package org.demo.features;
import java.util.List;

public class SequencedCollections {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.reversed());
    }

}

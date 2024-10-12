package org.demo.concepts.locks.reentrantLock;

public class Main2 {

    public static void main(String[] args) {
        SharedResource2 t1 = new SharedResource2();
        SharedResource2 t2 = new SharedResource2();
        t1.process();
        t2.process();
    }

}

package org.demo.concepts.synchronization.synchronisedmethod;

public class SynchronizationDemoMain {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Create multiple threads trying to withdraw from the same account
        Thread t1 = new Thread(new WithdrawTask(account), "Person 1");
        Thread t2 = new Thread(new WithdrawTask(account), "Person 2");
        Thread t3 = new Thread(new WithdrawTask(account), "Person 3");

        // Start the threads
        t1.start();
        t2.start();
        t3.start();
    }

}

package org.demo.concepts.synchronization.synchronisedmethod;

public class BankAccount {
    private int balance = 6000; // initial balance

    // Synchronized method to ensure only one thread can withdraw at a time
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() +
                    " is about to withdraw...");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " has withdrawn " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " tried to withdraw, but insufficient funds.");
        }
    }

    public int getBalance() {
        return balance;
    }
}

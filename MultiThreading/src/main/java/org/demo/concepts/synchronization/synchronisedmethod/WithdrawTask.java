package org.demo.concepts.synchronization.synchronisedmethod;

public class WithdrawTask implements Runnable {
    private BankAccount account;

    public WithdrawTask(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(3000); // each thread tries to withdraw Rs 3000
    }
}

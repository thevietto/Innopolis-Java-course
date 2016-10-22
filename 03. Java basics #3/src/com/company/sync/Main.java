package com.company.sync;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(1000);

        Thread thread = new Thread(() -> transfer(account1, account2, 500));
        thread.start();
        transfer(account2, account1, 700);
        thread.join();

        System.out.println(account1.getAmount());
        System.out.println(account2.getAmount());

    }

    public static void transfer(BankAccount account1, BankAccount account2, int amount) {
        lock.lock();
        System.out.println("transactrion");
        account1.withdraw(amount);
        account2.deposit(amount);
        lock.unlock();
    }

}

class BankAccount {

    private volatile int amount;

    public BankAccount(int amount) {
        this.amount = amount;
    }

    public synchronized void deposit(int value) {
        amount = amount + value;
    }

    public synchronized void withdraw(int value) {
        amount = amount - value;
    }

    public synchronized int getAmount() {
        return amount;
    }
}


























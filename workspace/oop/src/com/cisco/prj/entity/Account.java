package com.cisco.prj.entity;

public class Account {
    private double balance; // state, instance variable

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}

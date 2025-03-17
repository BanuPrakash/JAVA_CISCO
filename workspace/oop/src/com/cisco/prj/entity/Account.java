package com.cisco.prj.entity;

public class Account {
    private double balance; // state, instance variable

//    // default constructor
    public Account() {
        balance = 0.0; // optional
    }

//    // parameterized constructor
    public Account(double amt) {
        this.balance = amt;
    }

    // methods, actions , behaviours , messages
    public void deposit(double amount) {
        this.balance += amount;
        // balance += amount; is also valid, balance will translate to this.balance
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}

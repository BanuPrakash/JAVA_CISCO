package com.cisco.prj.entity;

public class Account {
    private double balance; // state, instance variable
    private static int count; // state of class, class member and not instance member

//    // default constructor
    public Account() {
        balance = 0.0; // optional
        count++;
    }

//    // parameterized constructor
    public Account(double amt) {
        this.balance = amt;
        count++;
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

    // class member
    public static int getCount() {
        return  count;
    }
}

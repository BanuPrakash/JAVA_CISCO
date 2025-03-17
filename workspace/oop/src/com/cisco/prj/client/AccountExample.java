package com.cisco.prj.client;

import com.cisco.prj.entity.Account;

public class AccountExample {
    public static void main(String[] args) {
        Account rahulAcc = new Account(); // calls  default constructor
        Account swethaAcc = new Account(8900); // parameterized constructor

        rahulAcc.deposit(4000);
        
        swethaAcc.deposit(5000);

        swethaAcc.withdraw(1500);

        System.out.println("Balance in Rahul Account :" + rahulAcc.getBalance());
        System.out.println("Balance in Swetha Account :" + swethaAcc.getBalance());
    }
}

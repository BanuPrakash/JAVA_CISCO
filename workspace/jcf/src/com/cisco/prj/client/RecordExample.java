package com.cisco.prj.client;

public class RecordExample {
    public static void main(String[] args) {
        Book b = new Book(35, "Java Ref", 890.00); // immutable
        System.out.println(b.title() + " , " + b.price()); // accessor

    }
}

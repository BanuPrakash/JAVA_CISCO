package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        Product[] products = new Product[6];
        products[0] = new Product(62, "iPhone 16", 98000.00, "mobile");
        products[1] = new Product(34, "Wacom", 4500.00, "computer");
        products[2] = new Product(81, "Sony Bravia", 2_98_000.00, "tv");
        products[3] = new Product(6, "LG OLED", 1_60_000.00, "tv");
        products[4] = new Product(24, "Logitech Mouse", 700.00, "computer");
        products[5] = new Product(89, "Samsung Fold", 95000.00, "mobile");

        String[] names = {"Penelope", "Brad", "Chris", "Angelina", "George","Anne"};

        Arrays.sort(names);

        for(String name : names) {
            System.out.println(name);
        }

        System.out.println("*****");

        System.out.println("Sort names based on Length:");
        // cleint provides the criteria for comparison --> Comparator
        Arrays.sort(names, new LengthComprator());
        for(String name : names) {
            System.out.println(name);
        }


        System.out.println("*******");
        Arrays.sort(products);

        for(Product p : products) {
            System.out.println(p); // toString()
        }
    }
}

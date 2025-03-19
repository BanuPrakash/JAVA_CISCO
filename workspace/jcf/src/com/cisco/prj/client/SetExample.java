package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
//        Set<Product> products  = new HashSet<>(24, 0.7f);
//        Set<Product> products = new TreeSet<>();

        // Comparator
//        Set<Product> products = new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));
     //   Set<Product> products = new TreeSet<>((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        Set<Product> products = new TreeSet<>((p1, p2) -> {
            int diff =   p1.getName().compareTo(p2.getName());
            if(diff == 0) {
                diff =  p1.getId() - p2.getId();
            }
            return  diff;
        });

        products.add(new Product(62, "iPhone 16", 98000.00, "mobile"));
        products.add(new Product(34, "Wacom", 4500.00, "computer"));
        products.add(new Product(81, "Sony Bravia", 2_98_000.00, "tv"));
        products.add(new Product(6, "LG OLED", 1_60_000.00, "tv"));
        products.add(new Product(24, "Logitech Mouse", 700.00, "computer"));
        products.add(new Product(89, "Samsung Fold", 95000.00, "mobile"));
        // duplicates are allowed
        products.add(new Product(34, "Wacom", 4500.00, "computer"));

        for(Product p : products) {
            System.out.println(p); // toString()
        }

    }
}

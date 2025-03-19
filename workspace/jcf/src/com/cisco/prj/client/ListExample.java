package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
//        List<Product> products = new ArrayList<>();
        List<Product> products  = new LinkedList<>();
        products.add(new Product(62, "iPhone 16", 98000.00, "mobile"));
        products.add(new Product(34, "Wacom", 4500.00, "computer"));
        products.add(new Product(81, "Sony Bravia", 2_98_000.00, "tv"));
        products.add(new Product(6, "LG OLED", 1_60_000.00, "tv"));
        products.add(new Product(24, "Logitech Mouse", 700.00, "computer"));
        products.add(new Product(89, "Samsung Fold", 95000.00, "mobile"));
        // duplicates are allowed
        products.add(new Product(34, "Wacom", 4500.00, "computer"));

        // Collections.sort(products); // comparable

        // comparator
        Collections.sort(products, (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));

        for(Product p : products) {
            System.out.println(p); // toString()
        }

        // can re-order
        Collections.sort(products);
        Collections.reverse(products);
        Collections.shuffle(products);

        // index based operations are supported...
        Product p = products.get(2);
        products.remove(1);

    }
}

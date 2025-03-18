package com.cisco.prj.client;

import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.Tv;
import com.cisco.prj.util.Utility;

public class SortClient {
    public static void main(String[] args) {
        Product[] products = new Product[4]; // Array of pointers to Product type, not actual Product
        products[0] = new Mobile(52, "iPhone 6", 89000.00, "5G");
        products[1] = new Tv(56, "Onida Thunder", 3200.00, "CRT");
        products[2] = new Tv(71, "Sony Bravia 6", 2_32_000.00, "OLED");
        products[3] = new Mobile(13, "MotoG", 12000.00, "4G");

        Utility.sort(products);

        for(Product p : products) {
            System.out.println(p.getName() + ", " + p.getPrice());
        }

        String[] names = {"Penelope", "Brad", "Chris", "Angelina", "George","Anne"};

        Utility.sort(names);

        for(String name : names) {
            System.out.println(name);
        }
    }
}

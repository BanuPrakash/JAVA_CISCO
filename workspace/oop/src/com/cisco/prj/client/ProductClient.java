package com.cisco.prj.client;

import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.Tv;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[5]; // Array of pointers to Product type, not actual Product
        products[0] = new Mobile(52, "iPhone 6", 89000.00, "5G");
        products[1] = new Tv(56, "Onida Thunder", 3200.00, "CRT");
        products[2] = new Tv(71, "Sony Bravia 6", 2_32_000.00, "OLED");
        products[3] = new Mobile(13, "MotoG", 12000.00, "5G");
        products[4] = new Product(511,"Dummy", 0); // should not be valid, fix it

        printExpensive(products);
    }

    private static void printExpensive(Product[] products) {
        for(Product p : products) {
            if(p.isExpensive()) { // dynamic binding, polymorphism
                System.out.println(p.getName() + " is Expensive!!!");
            } else {
                System.out.println(p.getName() + " is not expensive!!!");
            }
        }
    }
}

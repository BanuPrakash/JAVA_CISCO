package com.cisco.prj.client;

import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.Tv;

import java.lang.reflect.Method;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[5]; // Array of pointers to Product type, not actual Product
        products[0] = new Mobile(52, "iPhone 6", 89000.00, "5G");
        products[1] = new Tv(56, "Onida Thunder", 3200.00, "CRT");
        products[2] = new Tv(71, "Sony Bravia 6", 2_32_000.00, "OLED");
        products[3] = new Mobile(13, "MotoG", 12000.00, "4G");
        products[4] = new Product(511,"Dummy", 0); // should not be valid, fix it

        printExpensive(products);
        System.out.println("********");
        printDetails(products);

        printDetailsOCP(products);
    }

    // OCP
    private static void printDetailsOCP(Product[] products) {
        for(Product p : products) {
            Method[] methods = p.getClass().getMethods();
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    try {
                        Object ret = m.invoke(p); // m can be getId(), getPrice(),,,
                        System.out.println(m.getName().substring(3) + " : " + ret);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            System.out.println("%%%%%%%%");
        }
    }

    // Is this OCP?
    private static void printDetails(Product[] products) {
        for(Product p : products) {
            System.out.println(p.getName() + ", " + p.getPrice());
            // before down-casting, type checking has to be done
            if(p instanceof Mobile) {
                Mobile m = (Mobile) p; // down-casting
                System.out.println(m.getConnectivity());
            }
            if(p.getClass() == Tv.class) { // strict checking
                Tv t = (Tv) p;
                System.out.println(t.getScreenType());
            }
            System.out.println("-------");
        }
    }

    // OCP, this method is closed for Change and open for extension
    // if we add another type of product like WashingMachine, DishWasher, ...
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

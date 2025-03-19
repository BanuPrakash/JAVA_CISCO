package com.cisco.prj.client;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Double> bookMap = new HashMap<>();

        bookMap.put("React", 1200.00);
        bookMap.put("JavaScript", 4111.44);
        bookMap.put("Java", 890.11);
        bookMap.put("Oracle", 890.11); // valid

        bookMap.put("Java", 700.11); // it overwrites old entry



        Set<String> keys = bookMap.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + bookMap.get(key));
        }

        Collection<Double> values = bookMap.values();

        bookMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}

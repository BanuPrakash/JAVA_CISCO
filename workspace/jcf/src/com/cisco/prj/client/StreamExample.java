package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> products  = new LinkedList<>();
        products.add(new Product(62, "iPhone 16", 98000.00, "mobile"));
        products.add(new Product(34, "Wacom", 4500.00, "computer"));
        products.add(new Product(81, "Sony Bravia", 2_98_000.00, "tv"));
        products.add(new Product(6, "LG OLED", 1_60_000.00, "tv"));
        products.add(new Product(24, "Logitech Mouse", 700.00, "computer"));
        products.add(new Product(89, "Samsung Fold", 95000.00, "mobile"));

        // filter is HOF: accepts predicate function as argument
        products.stream()
                .filter(p -> p.getCategory().equals("tv"))
                .forEach(p -> System.out.println(p));

        // map is HOF: accepts transform function as argument
        products.stream()
                .map(p -> p.getName())
                .forEach(name -> System.out.println(name));

        // Need to get names of mobile only
        System.out.println("Mobile Names :");
        products.stream()
                .filter(p -> p.getCategory().equals("mobile"))
                .map(p -> p.getName())
                .forEach(name -> System.out.println(name));

        // Total of product prices

        double total =  products.stream()
                .map(p -> p.getPrice()) // 98000.00, 4500.00,2_98_000.00,
                .reduce( 0.0, (v1, v2) -> v1  + v2);
                // v1 --> 0 v2 -> 98000.00
                // v1 --> 98000 v2 --> 4500
                // v1 -> (98000 + 4500)  v2 --> 2_98_00.00

        System.out.println("Total Cost of all products : " + total);

        // Total of only mobiles
         total =  products.stream()
                .filter(p -> p.getCategory().equals("mobile"))
                 .map(p -> p.getPrice())
                 .reduce( 0.0, (v1, v2) -> v1  + v2);
        System.out.println("Total Cost of all Mobiles : " + total);

        System.out.println("Collect");

        List<String> names =  products.stream()
                .filter(p -> p.getCategory().equals("mobile"))
                .map(p -> p.getName())
                .collect(Collectors.toList());

        DoubleSummaryStatistics stats =
                products.stream().collect(Collectors.summarizingDouble(p -> p.getPrice()));

        System.out.println("Max : " + stats.getMax());
        System.out.println("Min : " + stats.getMin());
        System.out.println("Avg : " + stats.getAverage());
        System.out.println("Product Count : " + stats.getCount());
        System.out.println("Total Cost : " + stats.getSum());
    }
}

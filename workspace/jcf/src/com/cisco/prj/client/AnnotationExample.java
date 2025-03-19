package com.cisco.prj.client;

import com.cisco.prj.entity.Employee;
import com.cisco.prj.entity.Product;
import com.cisco.prj.util.AnnotationProcessor;

public class AnnotationExample {
    public static void main(String[] args) {
        String SQL = AnnotationProcessor.generateCreateStatement(Product.class);
        System.out.println(SQL);

        SQL = AnnotationProcessor.generateCreateStatement(Employee.class);
        System.out.println(SQL);

        Employee e = new Employee();
        e.setEmail("roger@cisco.com");
        e.setFirstName("Roger");

        SQL = AnnotationProcessor.generateInsertStatement(e);
        System.out.println(SQL);

        Product p = new Product(41, "iPhone", 89000.00, "mobile");
        SQL = AnnotationProcessor.generateInsertStatement(p);
        System.out.println(SQL);
    }
}

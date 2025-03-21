package com.cisco.prj.entity;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

import java.util.Objects;

@Table(name="products")
public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private double price;
    private String category;

    public Product() {
    }

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Column(name="PID", type = "NUMERIC(10)")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="PRD_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="AMT", type = "NUMERIC(12, 2)")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    // normally this contains comparison based on unique filed of class / PK
    @Override
    public int compareTo(Product o) {
        return this.id - o.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

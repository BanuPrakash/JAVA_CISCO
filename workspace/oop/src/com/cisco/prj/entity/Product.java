package com.cisco.prj.entity;

// Think Liskov substitution Principle while building generalized object
public abstract class Product implements Comparable {
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // i can't decide
//    public boolean isExpensive() {
//        return  false;
//    }

    public abstract boolean isExpensive();

    // p1.compareTo(p2);
    // p1 is "this"
    // p2 is passed as o
    public int compareTo(Object other){
        Product p = (Product) other;
        if(this.price > p.price) {
            return 1;
        } else  if(p.price > this.price) {
            return  -1;
        }
        return  0;
    }
}

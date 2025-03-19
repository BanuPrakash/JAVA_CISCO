package com.cisco.prj.client;


public class ObjectEquality {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4,5);
        Rectangle r2 = new Rectangle(4, 5);

        if( r1 == r2) {
            System.out.println("Same objects, same memory");
        }

        if(r1.equals(r2)) {
            System.out.println("Similar objects!!!");
        }

        System.out.println("HashCode of r1 : " + r1.hashCode());
        System.out.println("HashCode of r2 : " + r2.hashCode());

        System.out.println(r1); // toString
    }
}

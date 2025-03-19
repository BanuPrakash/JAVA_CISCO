package com.cisco.prj.client;

public class HashStory {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        if(s1 == s2) {
            System.out.println("s1 and s2 are same");
        } else {
            System.out.println("s1 and s2 are different");
        }

        String s3 = new String("Aa");
        String s4 = new String("BB");

        // just because hashcode of s3 and s4 are same doesn't mean they are similar
        System.out.println(s3.hashCode()); // 2112
        System.out.println(s4.hashCode()); // 2112
    }
}

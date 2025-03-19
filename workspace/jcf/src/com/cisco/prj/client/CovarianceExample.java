package com.cisco.prj.client;

import java.util.Arrays;
import java.util.List;

public class CovarianceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Roger", "James", "Larry", "Gomes");
        List<Integer> numbers = Arrays.asList(63, 11, 52, 56);

        printData(names);
        printData(numbers);
    }

//    private static void printData(List<Object> elems) {
private static void printData(List<?> elems) {
        for(Object obj: elems) {
            System.out.println(obj);
        }
    }
}

package com.example.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
    // Create a Counting Map
    private Map<String, Long> productCount = new HashMap<>();
    // Create a Name Mapping Map
    private Map<String, String> productNames = new TreeMap<>();

    public static void main(String[] args) {

        // List of part data
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Create Product Name Part Number map
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug   ", "1M02");

        // Create Product Counter Object and process data
        ProductCounter pc = new ProductCounter(productNames);
        pc.processList(parts);
        pc.printReport();
    }

    public ProductCounter(Map productNames) {
        // Your code here
        this.productNames = productNames;
    }

    public void processList(String[] list) {
        // your code here
        long curval = 0;
        for (String productNumber : list) {
            if (productCount.containsKey(productNumber)) {
                curval = productCount.get(productNumber);
                curval++;
                productCount.put(productNumber, new Long(curval));
            }else{
                productCount.put(productNumber, new Long(1));
            }
        }
    }

    public void printReport() {
        // Your code here
        System.out.println("=== Product Report ===");
        for(String productKey : productNames.keySet()) {
            System.out.println("Name: " + productKey);
            System.out.println("\tCount: " + productCount.get(productNames.get(productKey)));
        }
    }
}

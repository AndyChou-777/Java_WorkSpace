package com.example.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {
    // Create a Counting Map
	private Map<String, String> products;
    // Create a Name Mapping Map
	private Map<String, Integer> counts;

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
    	this.products = productNames;
    	this.counts = new HashMap<>();
    }

    public void processList(String[] list) {
        // your code here
    	for (String item:list) {
    		if (counts.containsKey(item)) {
    			int count = counts.get(item);
    			counts.put(item, ++count);
    		} else
    			counts.put(item, 1);
    	}
    }

    public void printReport() {
        // Your code here
    	System.out.println("===銷售報告===");
    	for (String name: products.keySet()) {
    		String key = products.get(name);
    		int count = counts.get(key);
    		System.out.printf("%-20s銷售%3d個%n", name, count);
    	}
    }
}
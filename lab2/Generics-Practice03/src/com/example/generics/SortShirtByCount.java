package com.example.generics;

import java.util.Comparator;

public class SortShirtByCount implements Comparator<Shirt> {

    public int compare(Shirt s1, Shirt s2) {
        // Your code here
        Long s1Count = s1.getCount();
        Long s2Count = s2.getCount();

        return s1Count.compareTo(s2Count);

    }
}

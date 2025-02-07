package com.example.generics;

import java.util.Comparator;

public class SortShirtByDesc implements Comparator<Shirt> {

    public int compare(Shirt s1, Shirt s2) {
        // Your code here
        String shirt1Desc = s1.getDescription();
        String shirt2Desc = s2.getDescription();

        return shirt1Desc.compareTo(shirt2Desc);
    }
}

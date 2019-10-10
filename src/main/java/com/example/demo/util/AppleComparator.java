package com.example.demo.util;

import com.example.demo.entity.Apple;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple> {


    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}

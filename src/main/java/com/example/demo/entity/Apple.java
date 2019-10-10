package com.example.demo.entity;

import lombok.Data;

@Data
public class Apple {
    private Integer weight = 0;
    private String color = "";

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}

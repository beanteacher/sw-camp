package com.ohgiraffers.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Beverage extends Product {
    private int capacity; //용량
    public Beverage() {
        super();
    }
    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

}
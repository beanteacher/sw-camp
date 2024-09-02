package com.ohgiraffers.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Bread extends Product {
    private Date bakedDate; //생산시간
    public Bread() {
        super();
    }
    public Bread(String name, int price, java.util.Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }
}
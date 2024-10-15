package com.ohgiraffers.transactional.section01.annotation;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private int OrderCode;
    private String orderDate;
    private String orderTime;
    private int totalOrderPrice;

    public Order(LocalDate orderDate, LocalTime orderTime, int totalOrderPrice) {
        this.orderDate = orderDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.orderTime = orderTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.totalOrderPrice = totalOrderPrice;
    }
}

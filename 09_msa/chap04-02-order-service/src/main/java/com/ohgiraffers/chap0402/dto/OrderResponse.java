package com.ohgiraffers.chap0402.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private int orderCode;
    private String orderDate;
    private String orderTime;
    private List<OrderMenu> orderMenuList;
}

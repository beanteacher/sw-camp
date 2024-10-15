package com.ohgiraffers.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderInfoResponse {
    private int orderCode;
    private String orderDate;
    private String orderTime;
    private List<OrderMenu> orderMenuList;
}

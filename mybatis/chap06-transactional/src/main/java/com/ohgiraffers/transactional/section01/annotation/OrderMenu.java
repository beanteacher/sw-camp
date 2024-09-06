package com.ohgiraffers.transactional.section01.annotation;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderMenu {

    private int orderCode;
    private int menuCode;
    private int orderAmount;
}

package com.ohgiraffers.transactional.section01.annotation;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderMenuDTO {
    private int menuCode;
    private int orderAmount;
}

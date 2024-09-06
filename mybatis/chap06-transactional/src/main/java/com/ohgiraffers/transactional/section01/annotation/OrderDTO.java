package com.ohgiraffers.transactional.section01.annotation;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/* 테이블의 필드와 꼭 일치할 필요 없이 주문을 위해서 사용자가 넘겨 준 값을 담아
* 계층을 넘어다니며 값을 옮겨줄 수 있는 클래스를 작성한다.
* (DTO : Data Transfer Object)*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private LocalDate orderDate;
    private LocalTime orderTime;
    private List<OrderMenuDTO> orderMenuList;
}

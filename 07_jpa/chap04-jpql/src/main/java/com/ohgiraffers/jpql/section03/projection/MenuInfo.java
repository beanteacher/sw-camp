package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Embeddable;
import lombok.ToString;

@Embeddable
@ToString
public class MenuInfo {
    private String menuName;
    private int menuPrice;
}

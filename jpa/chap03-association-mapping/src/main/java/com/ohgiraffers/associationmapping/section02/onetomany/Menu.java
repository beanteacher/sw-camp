package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "section02Menu")
@Table(name = "tbl_menu")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;

    private String orderableStatus;
}
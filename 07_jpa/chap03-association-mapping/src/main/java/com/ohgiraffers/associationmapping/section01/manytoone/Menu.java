package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "section01Menu")
@Table(name = "tbl_menu")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryCode")
    private Category category;

    private String orderableStatus;
}
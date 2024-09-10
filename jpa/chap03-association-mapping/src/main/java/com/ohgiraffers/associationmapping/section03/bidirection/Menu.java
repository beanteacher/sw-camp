package com.ohgiraffers.associationmapping.section03.bidirection;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "section03Menu")
@Table(name = "tbl_menu")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private Category category;

    private String orderableStatus;
}
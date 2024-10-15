package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Section02Category")
@Table(name = "tbl_category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryCode")
    private List<Menu> menuList;
}

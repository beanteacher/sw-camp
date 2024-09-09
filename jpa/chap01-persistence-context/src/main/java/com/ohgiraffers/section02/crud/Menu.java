package com.ohgiraffers.section02.crud;

import jakarta.persistence.*;

@Entity(name = "Section02Menu")
@Table(name = "TBL_MENU")
public class Menu {

    @Id
    @Column(name="MENU_CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    @Column(name="MENU_NAME")
    private String menuName;

    @Column(name="MENU_PRICE")
    private int menuPrice;

    @Column(name="CATEGORY_CODE")
    private int categoryCode;

    @Column(name="ORDERABLE_STATUS")
    private String orderableStatus;

    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public Menu() {}

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus=" + orderableStatus +
                '}';
    }
}

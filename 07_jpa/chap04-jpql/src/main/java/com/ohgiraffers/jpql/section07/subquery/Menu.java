package com.ohgiraffers.jpql.section07.subquery;

import com.ohgiraffers.jpql.section03.projection.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="Section07Menu")
@Table(name="tbl_menu")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu {
    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;
}

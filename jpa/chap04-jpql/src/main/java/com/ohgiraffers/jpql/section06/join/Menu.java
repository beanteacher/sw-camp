package com.ohgiraffers.jpql.section06.join;

import com.ohgiraffers.jpql.section03.projection.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="Section06Menu")
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
    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private Category category;
    private String orderableStatus;
}

package com.ohgiraffers.associationmapping.section03.bidirection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BiDirectionServiceTest {

    @Autowired
    private BiDirectionService biDirectionService;

    @DisplayName("양방향 연관 관계 매핑 조회 테스트1 (연관 관계의 진짜 주인)")
    @Test
    void biDirectionMenuTest() {
        int menuCode = 3;
        Menu menu = biDirectionService.findMenu(menuCode);

        System.out.println(menu);
        assertNotNull(menu);
    }

    @DisplayName("양방향 연관 관계 매핑 조회 테스트2 (연관 관계의 가짜 주인)")
    @Test
    void biDirectionCategoryTest() {
        int categoryCode = 9;
        Category category = biDirectionService.findCategory(categoryCode);

        System.out.println(category);
        assertNotNull(category);
    }
}
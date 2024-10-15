package com.ohgiraffers.associationmapping.section01.manytoone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManyToOneMenuServiceTest<New> {
    @Autowired
    private ManyToOneMenuService menuService;

    @DisplayName("N:1 연관관계 객체 그래프 탐색을 이용한 조회 테스트")
    @Test
    void manyToOneFindTest() {
        // given
        int menuCode = 9; // DB에 존재하는 코드로
        // when
        Menu menu = menuService.findMenu(menuCode);

        Category category = menu.getCategory();
        System.out.println(category);
        assertNotNull(category);
    }

    @DisplayName("N:1 연관관계 객체 지향 쿼리(jpql)을 이용한 조회 테스트")
    @Test
    void manyToOneJpqlTest() {
        // given
        int menuCode = 9; // DB에 존재하는 코드로
        // when
        String categoryName = menuService.findCategoryNameByJpql(menuCode);

        assertNotNull(categoryName);
        System.out.println("categoryName : " + categoryName);
    }

    private static Stream<Arguments> getMenuInfo() {
        return Stream.of(
                Arguments.arguments(123, "돈가스 스파게티", 30000, 123, "퓨전분식", "Y")
        );
    }

    @DisplayName("N:1 연관관계 객체 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getMenuInfo")
    void manyToOneInsertTest(
            int menuCode, String menuName, int menuPrice,
            int categoryCode, String categoryName, String orderableStatus
    ) {
        //given
        MenuDTO menuInfo = new MenuDTO(
                menuCode,
                menuName,
                menuPrice,
                new CategoryDTO(categoryCode, categoryName, null),
                orderableStatus
        );

        //when
        //then
        Assertions.assertDoesNotThrow(
                () -> menuService.registMenu(menuInfo)
        );
    }

}
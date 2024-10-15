package com.ohgiraffers.jpql.section01.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleJPQLRepositoryTest {

    @Autowired
    private SimpleJPQLRepository simpleJPQLRepository;

    @Test
    @DisplayName("JPQL SELECT")
    void testSelectSingleMenuByTypedQuery() {
        String menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();
        System.out.println(menuName);

        assertEquals("한우딸기국밥", menuName);
    }

    @Test
    @DisplayName("JPQL SELECT OBJECT")
    void testSelectSingleMenuByQuery() {
        String menuName = simpleJPQLRepository.selectSingleMenuByQuery();
        System.out.println(menuName);

        assertEquals("한우딸기국밥", menuName);
    }

    @Test
    @DisplayName("JPQL SELECT SINGLE OBJECT")
    void testSelectSingleRowByTypedQuery() {
        Menu menu = simpleJPQLRepository.selectSingleRowByTypedQuery();
        System.out.println(menu);

        assertNotNull(menu);
    }

    @Test
    @DisplayName("JPQL SELECT LIST")
    void testSelectByTypedQuery() {
        List<Menu> menuList = simpleJPQLRepository.selectByTypedQuery();
        for(Menu menu : menuList) {
            System.out.println(menu);
        }
        assertNotNull(menuList);
    }

    @Test
    @DisplayName("DISTINCT SELECT LIST")
    void testSelectUsingDistinct() {
        List<Integer> categoryCodeList = simpleJPQLRepository.selectUsingDistinct();

        System.out.println(categoryCodeList);
        assertNotNull(categoryCodeList);
    }

    @Test
    @DisplayName("IN SELECT LIST")
    void testSelectUsingIn() {
        List<Menu> menuList = simpleJPQLRepository.selectUsingIn();

        for(Menu menu : menuList) {
            System.out.println(menu);
        }
        assertNotNull(menuList);
    }

    @Test
    @DisplayName("LIKE SELECT LIST")
    void testSelectUsingLike() {
        String searchName = "마눌";
        List<Menu> menuList = simpleJPQLRepository.selectUsingLike(searchName);

        for(Menu menu : menuList) {
            System.out.println(menu);
        }
        assertNotNull(menuList);
    }
}
package com.ohgiraffers.jpql.section07.subquery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubQueryRepositoryTest {

    @Autowired
    private SubQueryRepository subQueryRepository;

    @Test
    @DisplayName("서브쿼리 테스트")
    public void testSubQuery() {
        String categoryName = "한식";

        List<Menu> menuList = subQueryRepository.selectWithSubQuery(categoryName);
        menuList.forEach(System.out::println);
    }
}
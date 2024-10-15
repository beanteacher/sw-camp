package com.ohgiraffers.jpql.section08.namedquery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class NamedQueryRepositoryTest {

    @Autowired
    private NamedQueryRepository namedQueryRepository;

    @DisplayName("동적쿼리를 이용한 조회 테스트")
    @Test
    public void testSelectByDynamicQuery() {
        //given
        String searchName = "마늘";
        int searchCode = 8;

        //when
        List<Menu> menuList = namedQueryRepository.selectByDynamicQuery(searchName, searchCode);

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

}
package com.ohgiraffers.jpql.section04.paging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PagingRepositoryTest {

    @Autowired
    private PagingRepository pagingRepository;

    @Test
    @DisplayName("")
    public void testPaging() {
        int offset = 5;
        int limit = 10;
        List<Menu> menuList = pagingRepository.usingPagingAPI(offset, limit);
        menuList.forEach(System.out::println);
        assertFalse(menuList.isEmpty());
    }
}
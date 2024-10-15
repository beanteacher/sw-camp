package com.ohgiraffers.jpql.section06.join;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JoinRepositoryTest {

    @Autowired
    JoinRepository joinRepository;

    @DisplayName("내부 조인 테스트")
    @Test
    void testSelectByInnerJoin() {
        List<Menu> menuList = joinRepository.selectByInnerJoin();
        menuList.forEach(System.out::println);
        assertNotNull(menuList);
    }

    @DisplayName("패치 조인 테스트")
    @Test
    void testSelectByFetchJoin() {
        List<Menu> menuList = joinRepository.selectByFetchJoin();
        menuList.forEach(System.out::println);
        assertNotNull(menuList);
    }

    @DisplayName("아우터 조인 테스트")
    @Test
    void testSelectByOuterJoin() {
        List<Object[]> menuList = joinRepository.selectByOuterJoin();
        for(Object[] o : menuList) {
            System.out.println(Arrays.toString(o));
        }
        assertNotNull(menuList);
    }

    @DisplayName("컬렉션 조인 테스트")
    @Test
    void testSelectByCollectionJoin() {
        List<Object[]> menuList = joinRepository.selectByCollectionJoin();
        for(Object[] o : menuList) {
            System.out.println(Arrays.toString(o));
        }
        assertNotNull(menuList);
    }

    @DisplayName("세타 조인 테스트")
    @Test
    void testSelectByThetaJoin() {
        List<Object[]> menuList = joinRepository.selectByThetaJoin();
        for(Object[] o : menuList) {
            System.out.println(Arrays.toString(o));
        }
        assertNotNull(menuList);
    }
}
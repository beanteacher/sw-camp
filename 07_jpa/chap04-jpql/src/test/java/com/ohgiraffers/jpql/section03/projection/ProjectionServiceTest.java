package com.ohgiraffers.jpql.section03.projection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectionServiceTest {
    @Autowired
    private ProjectionService projectionService;
    @Autowired
    private ProjectionRepository projectionRepository;

    @Test
    @DisplayName("JPQL로 커밋")
    public void testSingleEntityProjection() {
        List<Menu> menuList = projectionService.singleEntityProjection();

        assertNotNull(menuList);
    }

    @Test
    @DisplayName("임베디드 타입 프로젝션")
    void testEmbeddedTypeProjection() {
        List<MenuInfo> menuInfoList = projectionRepository.embeddedTypeProjection();
        System.out.println(menuInfoList);
        assertNotNull(menuInfoList);
    }

    @Test
    @DisplayName("스칼라 타입 프로젝션")
    void testScalarTypeProjection() {
        List<Object[]> scalarList = projectionRepository.scalarTypeProjection();
        for(Object[] os : scalarList) {
            System.out.println(Arrays.toString(os));
        }
        assertNotNull(scalarList);
    }

    @Test
    @DisplayName("new 명령어 프로젝션")
    void testNewCommandProjection() {
        List<CategoryInfo> categoryInfoList = projectionRepository.newCommandProjection();
        assertNotNull(categoryInfoList);
        categoryInfoList.forEach(System.out::println);
    }
}
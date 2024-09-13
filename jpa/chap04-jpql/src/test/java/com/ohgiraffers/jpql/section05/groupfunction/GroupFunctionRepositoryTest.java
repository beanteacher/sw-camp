package com.ohgiraffers.jpql.section05.groupfunction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GroupFunctionRepositoryTest {

    @Autowired
    private GroupFunctionRepository groupFunctionRepository;

    @Test
    @DisplayName("특정 카테고리에 해당하는 메뉴 수  조회")
    void testCountMenuOfCategory() {
        int categoryCode=777;
        long countOfMenu = groupFunctionRepository.countMenuOfCategory(categoryCode);
        System.out.println(countOfMenu);

    }

    @Test
    @DisplayName("특정 카테고리에 해당하는 가격의 합 조회")
    void testSumMenuOfCategory() {
        int categoryCode=777;
        Long sumMenuPrice = groupFunctionRepository.sumMenuPriceOfCategory(categoryCode);

        System.out.println(sumMenuPrice);
    }

    @DisplayName("Having 절 조회 테스트")
    @Test
    void testSelectByGroupByHaving() {
        long minPrice = 50000L;
        List<Object[]> sumPriceOfCategoryList = groupFunctionRepository.selectByGroupByHaving(minPrice);
        sumPriceOfCategoryList.forEach(System.out::println);
    }
}
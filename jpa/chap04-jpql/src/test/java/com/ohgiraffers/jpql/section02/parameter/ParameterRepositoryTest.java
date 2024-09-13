package com.ohgiraffers.jpql.section02.parameter;

import com.ohgiraffers.jpql.section01.simple.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParameterRepositoryTest {

    @Autowired
    private ParameterRepository parameterRepository;
    @DisplayName("이름 기준 파라미터 바인딩 테스트")
    @Test
    void testParameterBindingByName() {
        String menuName = "한우딸기국밥";
        List<Menu> menuList =  parameterRepository.selectMenuByBindignPosition(menuName);
        System.out.println(menuList.get(0).getMenuName());
    }

    @DisplayName("이름 기준 파라미터 바인딩 테스트")
    @Test
    void testParameterBindingByPsa() {
        String menuName = "한우딸기국밥";
        List<Menu> menuList =  parameterRepository.selectMenuByBindingName(menuName);
        System.out.println(menuList.get(0).getMenuName());
    }
}
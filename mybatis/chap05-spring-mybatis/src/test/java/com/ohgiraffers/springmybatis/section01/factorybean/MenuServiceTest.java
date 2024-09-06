package com.ohgiraffers.springmybatis.section01.factorybean;

import com.ohgiraffers.springmybatis.section01.factorybean.dto.MenuDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MenuServiceTest {
    @Autowired
    private MenuService menuService;

    @DisplayName("주문 가능 상태별 메뉴 조회 확인 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Y", "N"})
    void testFindAllMenu(String orderableStatus) {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<MenuDTO> menuList = menuService.findAllMenuByOrderableStatus(orderableStatus);
                    menuList.forEach(System.out::println);
                }
        );
    }

}
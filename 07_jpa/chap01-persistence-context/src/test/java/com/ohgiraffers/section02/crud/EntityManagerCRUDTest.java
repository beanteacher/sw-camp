package com.ohgiraffers.section02.crud;

import org.hibernate.annotations.Parameter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EntityManagerCRUDTest {

    private EntityManagerCRUD entityManagerCRUD;

    @BeforeEach
    void init() { this.entityManagerCRUD = new EntityManagerCRUD(); }

    @DisplayName("메뉴 코드로 메뉴 조회")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2","3,3"}) // CSV (Comma Separated Values) 콤마 기준으로 구분
    void testFindMethodByMenuCode(int menuCode, int expected) {
        System.out.println(menuCode);
        Menu foundMenu = entityManagerCRUD.findMenuByMenuCode(menuCode);
        assertEquals(expected, foundMenu.getMenuCode());
    }

    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.arguments(
                        "신메뉴"
                        ,35000
                        ,4
                        ,"Y"
                )
        );
    }

    @DisplayName("새로운 메뉴 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testRegist(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        Long cnt = entityManagerCRUD.saveAndReturnAllCount(menu);

        assertEquals(30, cnt);
    }

    @DisplayName("메뉴 명 수정 테스트")
    @ParameterizedTest
    @CsvSource("1, 변경 된 이름")
    void testModifyMenuName(int menuCode, String menuName) {
        Menu modifiedMenu = entityManagerCRUD.modifyMenuName(menuCode, menuName);

        assertEquals(menuName, modifiedMenu.getMenuName());
    }

    @DisplayName("메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {107})
    void testModifyMenuName(int menuCode) {
        long cnt = entityManagerCRUD.removeAndReturnAllCount(menuCode);

        assertEquals(29, cnt);
    }
}
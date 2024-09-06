package com.ohgiraffers.transactional.section01.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
/* DML 작업 테스티 시 실제 DB 적용을 하지 않기 위해서
* 테스트 수행 후 ROLLBACK 요청하는 기능 */
@Transactional
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    private static Stream<Arguments> getOrderInfo() {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderDate(LocalDate.now());
        orderDTO.setOrderTime(LocalTime.now());
        orderDTO.setOrderMenuList(List.of(new OrderMenuDTO(3, 10)
                ,new OrderMenuDTO(4, 5)
                ,new OrderMenuDTO(6, 3)));
        return Stream.of(Arguments.arguments(orderDTO));
    }

    @DisplayName("주문 등록 테스트")
    @ParameterizedTest
    @MethodSource("getOrderInfo")
    void testRegistNewOrder(OrderDTO orderDTO) {
        Assertions.assertDoesNotThrow(
                () -> orderService.registNewOrder(orderDTO)
        );
    }
}
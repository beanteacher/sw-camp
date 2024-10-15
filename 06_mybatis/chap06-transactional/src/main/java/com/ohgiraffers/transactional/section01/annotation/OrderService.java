package com.ohgiraffers.transactional.section01.annotation;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final MenuMapper menuMapper;
    private final OrderMapper orderMapper;

    /* Service 계층부터 개발할 경우 사용자 입력 값이 어떻게 DTO or Map으로 묶여서
    * Controller 계층에서 넘어올지를 충분히 고민한 후 매개변수를 작성한다. */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void registNewOrder(OrderDTO orderDTO) {

        /* 1. 주문한 메뉴코드 추출 */
        List<Integer> menuCode = orderDTO.getOrderMenuList()
                .stream()
                .map(OrderMenuDTO::getMenuCode)
                .toList();

        /* 2. 주문한 메뉴 별로 Menu 엔터티에 담아서 조회해오기 - 부가적인 메뉴의 정보 추출*/
        List<Menu> menuList = menuMapper.selectMenuByMenuCodes(menuCode);
        menuList.forEach(System.out::println);

        /* 3. 해당 주문건의 총 합계를 계산 */
        int totalOrderPrice = calcTotalOrderPrice(orderDTO.getOrderMenuList(), menuList);
        System.out.println(totalOrderPrice);

        /* 4.tbl_order insert */
        Order order = new Order(orderDTO.getOrderDate(), orderDTO.getOrderTime(), totalOrderPrice);
        orderMapper.registOrder(order);
        System.out.println(order);

        /* 5. tbl_order_menu insert */
        for(OrderMenuDTO orderMenuDTO : orderDTO.getOrderMenuList()) {
            OrderMenu orderMenu = new OrderMenu(order.getOrderCode(), orderMenuDTO.getMenuCode(), orderMenuDTO.getOrderAmount());
            orderMapper.registOrderMenu(orderMenu);
        }
    }

    private int calcTotalOrderPrice(List<OrderMenuDTO> orderMenus, List<Menu> menus) {

        int totalOrderPrice = 0;

        for(int i = 0; i < orderMenus.size(); i++) {
            totalOrderPrice += menus.get(i).getMenuPrice() * orderMenus.get(i).getOrderAmount();
        }

        return totalOrderPrice;
    }
}
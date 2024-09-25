package com.ohgiraffers.chap0402.controller;

import com.ohgiraffers.chap0402.dto.OrderResponse;
import com.ohgiraffers.chap0402.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders/users/{id}")
    public ResponseEntity<List<OrderResponse>> selectOrder(@PathVariable Long id) {
        List<OrderResponse> orderList = orderService.selectOrder(id);

        return ResponseEntity.ok(orderList);
    }
}

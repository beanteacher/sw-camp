package com.ohgiraffers.chap0402.service;

import com.ohgiraffers.chap0402.dto.OrderResponse;
import com.ohgiraffers.chap0402.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public List<OrderResponse> selectOrder(Long id) {
        return orderMapper.selectOrder(id);
    }
}

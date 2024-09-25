package com.ohgiraffers.chap0402.mapper;

import com.ohgiraffers.chap0402.dto.OrderResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderResponse> selectOrder(Long id);
}

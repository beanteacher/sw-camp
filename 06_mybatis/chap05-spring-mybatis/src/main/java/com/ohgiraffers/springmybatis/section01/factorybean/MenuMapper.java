package com.ohgiraffers.springmybatis.section01.factorybean;

import com.ohgiraffers.springmybatis.section01.factorybean.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus);
}

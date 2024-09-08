package com.ohgiraffers.springmybatis.section01.factorybean;

import com.ohgiraffers.springmybatis.section01.factorybean.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final SqlSessionTemplate sqlSession;


    public List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus) {
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = mapper.findAllMenuByOrderableStatus(orderableStatus);

        return menuList;
    }
}

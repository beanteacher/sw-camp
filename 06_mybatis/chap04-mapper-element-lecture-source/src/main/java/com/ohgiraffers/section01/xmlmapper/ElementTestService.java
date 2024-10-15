package com.ohgiraffers.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {

    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);
        List<MenuDTO> menuList = mapper.selectResultMapTest();

        if(menuList != null && !menuList.isEmpty()) {
            menuList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategoryDTO> menuCategoryList = mapper.selectResultMapAssociationTest();

        if(menuCategoryList != null && !menuCategoryList.isEmpty()) {
            menuCategoryList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> categoryList = mapper.selectResultMapCollectionTest();

        if(categoryList != null && !categoryList.isEmpty()) {
            categoryList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과가 존재하지 않습니다.");
        }

        sqlSession.close();
    }
}
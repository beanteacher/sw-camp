package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("menu.selectAllMenu");
    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("menu.selectMenuByMenuCode", menuCode);
    }

    public int registMenu(SqlSession sqlSession, MenuDTO menuDTO) {
        return sqlSession.insert("menu.registMenu", menuDTO);
    }

    public int modifyMenu(SqlSession sqlSession, MenuDTO menuDTO) {
        return sqlSession.update("menu.modifyMenu", menuDTO);
    }

    public int deleteMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("menu.deleteMenu", menuCode);
    }
}

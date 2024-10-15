package com.ohgiraffers.section01.xmlconfig;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        this.menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        MenuDTO menuDTO = menuDAO.selectMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();
        return menuDTO;
    }

    public int registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();

        int count = menuDAO.registMenu(sqlSession, menuDTO);
        if(count > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return count;
    }

    public int modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();

        int count = menuDAO.modifyMenu(sqlSession, menuDTO);
        if(count > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return count;
    }

    public int deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        int count = menuDAO.deleteMenu(sqlSession, menuCode);
        if(count > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return count;
    }
}

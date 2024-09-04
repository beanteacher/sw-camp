package com.ohgiraffers.section03.remix;

import java.util.List;

public interface MenuMapper {

    List<MenuDTO> selectAllMenu();
    MenuDTO selectMenuByMenuCode();
    int registMenu(MenuDTO menuDTO);
    int modifyMenu(MenuDTO menuDTO);
    int deleteMenu(int menuCode);
}
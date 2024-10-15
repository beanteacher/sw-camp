package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {
    @Results(id="menuResultMap", value = {
            @Result(id = true, property = "menuCode", column = "menu_code"),
            @Result(property = "menuName", column = "menu_name"),
            @Result(property = "menuPrice", column = "menu_price"),
            @Result(property = "categoryCode", column = "category_code"),
            @Result(property = "orderableStatus", column = "orderable_status"),
    })
    @Select("        SELECT\n" +
            "               menu_code\n" +
            "             , menu_name\n" +
            "             , menu_price\n" +
            "             , category_code\n" +
            "             , orderable_status\n" +
            "          FROM tbl_menu\n" +
            "         WHERE orderable_status = 'Y'\n" +
            "         ORDER BY menu_code")
    List<MenuDTO> selectAllMenu();

    @ResultMap("menuResultMap")
    @Select("SELECT MENU_CODE\n" +
            "            , MENU_NAME\n" +
            "            , MENU_PRICE\n" +
            "            , CATEGORY_CODE\n" +
            "            , ORDERABLE_STATUS\n" +
            "        FROM TBL_MENU\n" +
            "        WHERE ORDERABLE_STATUS = 'Y'\n" +
            "            AND MENU_CODE = #{menuCode}\n" +
            "        ORDER BY MENU_CODE")
    MenuDTO selectMenuByMenuCode();

    @Insert("INSERT INTO\n" +
            "            TBL_MENU (\n" +
            "                MENU_NAME\n" +
            "                , MENU_PRICE\n" +
            "                , CATEGORY_CODE\n" +
            "                , ORDERABLE_STATUS\n" +
            "        )\n" +
            "        VALUES (\n" +
            "            #{menuName}\n" +
            "            , #{menuPrice}\n" +
            "            , #{categoryCode}\n" +
            "            , 'Y'\n" +
            "        )")
    int registMenu(MenuDTO menuDTO);

    @Update("UPDATE TBL_MENU\n" +
            "        SET MENU_NAME = #{menuName}\n" +
            "            , MENU_PRICE = #{menuPrice}\n" +
            "            , CATEGORY_CODE = #{categoryCode}\n" +
            "        WHERE MENU_CODE = #{menuCode}")
    int modifyMenu(MenuDTO menuDTO);

    @Delete("  DELETE FROM TBL_MENU\n" +
            "        WHERE MENU_CODE = #{value}")
    int deleteMenu(int menuCode);
}
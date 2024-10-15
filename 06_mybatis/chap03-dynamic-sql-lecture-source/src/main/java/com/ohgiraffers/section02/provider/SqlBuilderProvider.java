package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilderProvider {

    public String registMenu(MenuDTO menuDTO) {
        return new SQL()
                .INSERT_INTO("TBL_MENU")
                .VALUES("MENU_NAME", "#{menuName}")
                .VALUES("MENU_PRICE", "#{menuPrice}")
                .VALUES("CATEGORY_CODE", "#{categoryCode}")
                .VALUES("ORDERABLE_STATUS", "#{orderableStatus}")
                .toString();
    }

    public String modifyMenu(MenuDTO menuDTO) {
        SQL sql = new SQL();
        sql.UPDATE("TBL_MENU");
        if(menuDTO.getMenuName() != null & !menuDTO.getMenuName().equals("")) {
            sql.SET("MENU_NAME = #{menuName}");
        }
        if(menuDTO.getOrderableStatus() != null & !menuDTO.getOrderableStatus().equals("")) {
            sql.SET("ORDERABLE_STATUS = #{orderableStatus}");
        }
        if(menuDTO.getCategoryCode() > 0) {
            sql.SET("CATEGORY_CODE = #{categoryCode}");
        }
        if(menuDTO.getMenuPrice() > 0) {
            sql.SET("MENU_PRICE = #{menuPrice}");
        }
        sql.WHERE("MENU_CODE = #{menuCode}");

        return sql.toString();
    }

    public String deleteMenu() {
        return new SQL()
                .DELETE_FROM("TBL_MENU")
                .WHERE("MENU_CODE = #{menuCode}")
                .toString();
    }
}

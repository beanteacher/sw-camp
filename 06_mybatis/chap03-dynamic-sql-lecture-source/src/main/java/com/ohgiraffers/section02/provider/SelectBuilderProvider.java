package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.jdbc.SQL;

public class SelectBuilderProvider {
    public String selectAllMenu() {
        return new SQL()
                .SELECT("MENU_CODE")
                .SELECT("MENU_NAME")
                .SELECT("MENU_PRICE")
                .SELECT("CATEGORY_CODE")
                .SELECT("ORDERABLE_STATUS")
                .FROM("TBL_MENU")
                .WHERE("ORDERABLE_STATUS='Y'")
                .toString();
    }

    public String searchMenuByNameOrCategory(SearchCriteria searchCriteria) {
        SQL sql = new SQL();
        sql.SELECT("MENU_CODE"
                        , "MENU_NAME"
                        , "MENU_PRICE"
                        , "CATEGORY_CODE"
                        , "ORDERABLE_STATUS")
                .FROM("TBL_MENU");

        if("category".equals(searchCriteria.getCondition())) {
            sql.JOIN("TBL_CATEGORY USING (CATEGORY_CODE)")
                    .WHERE("ORDERABLE_STATUS = 'Y'")
                    .AND()
                    .WHERE("CATEGORY_NAME = #{value}");
        } else if ("name".equals(searchCriteria.getCondition())) {
            // where 메소드에 가변 인자로 전달 시 자동적으로 AND로 조건이 처리되므로 OR의 경우 별도 메소드를 사용할 것
            sql.WHERE("ORDERABLE_STATUS = 'Y'", "MENU_NAME LIKE CONCAT('%', #{value}, '%')");
        }

        return sql.toString();
    }
}

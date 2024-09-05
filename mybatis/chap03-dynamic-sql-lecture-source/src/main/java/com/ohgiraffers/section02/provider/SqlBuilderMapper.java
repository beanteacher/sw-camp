package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.annotations.*;

public interface SqlBuilderMapper {

    @InsertProvider(type = SqlBuilderProvider.class, method = "registMenu")
    int registMenu(MenuDTO menuDTO);

    @UpdateProvider(type = SqlBuilderProvider.class, method = "modifyMenu")
    int modifyMenu(MenuDTO menuDTO);

    /* 기본 자료형 값을 전달하는 경우 @Param 어노테이션을 사용해야한다.
    * 또한 전달 값이 2개 이상인 경우도 @Param 어노테이션을 이용해야한다.
    * 단, Provider 메소드의 매개변수 선언부는 없어야한다. */
    @DeleteProvider(type = SqlBuilderProvider.class, method = "deleteMenu")
    int deleteMenu(@Param("menuCode") int menuCode);
}

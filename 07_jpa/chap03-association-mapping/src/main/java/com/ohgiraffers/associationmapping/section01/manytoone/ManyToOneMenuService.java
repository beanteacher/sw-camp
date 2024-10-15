package com.ohgiraffers.associationmapping.section01.manytoone;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ManyToOneMenuService {

    private final ManyToOneMenuRepository menuRepository;
    private final ManyToOneMenuRepository manyToOneMenuRepository;

    public Menu findMenu(int menuCode) {
        return menuRepository.find(menuCode);
    }

    public String findCategoryNameByJpql(int menuCode) {
        return manyToOneMenuRepository.findCategoryName(menuCode);
    }

    @Transactional
    public void registMenu(MenuDTO dto) {
        System.out.println(dto);

        Menu menu = new Menu(
                dto.getMenuCode(),
                dto.getMenuName(),
                dto.getMenuPrice(),
                new Category(dto.getCategory().getCategoryCode(),
                        dto.getCategory().getCategoryName(),
                        dto.getCategory().getRefCategoryCode()),
                dto.getOrderableStatus());
        System.out.println(menu);
        manyToOneMenuRepository.regist(menu);
    }
}

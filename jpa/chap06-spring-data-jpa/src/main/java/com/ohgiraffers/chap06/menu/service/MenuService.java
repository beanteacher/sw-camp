package com.ohgiraffers.chap06.menu.service;

import com.ohgiraffers.chap06.menu.dto.CategoryDTO;
import com.ohgiraffers.chap06.menu.dto.MenuDTO;
import com.ohgiraffers.chap06.menu.entity.Category;
import com.ohgiraffers.chap06.menu.entity.Menu;
import com.ohgiraffers.chap06.menu.repository.CategoryRepository;
import com.ohgiraffers.chap06.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    /* Entity to DTO 작업이 필요하다.
    * 1. 수동 매핑 메소드 작성 (toEntity, fromEntity, toDTO, fromDTO ...)
    * 2. 자동 매핑 라이브러리 사용 */

    /* 1. findById */
    public MenuDTO findMenuByCode(int menuCode) {
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalAccessError::new);

        return modelMapper.map(menu, MenuDTO.class);
    }

    /* 2. findAll(Sort) */
    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(
                Sort.by("menuCode")
                        .descending());

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* 2. findAll(Pageable) */
    public Page<MenuDTO> findMenuList(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                pageable.getSort().descending()
        );
        Page<Menu> menuList = menuRepository.findAll(pageable);

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice, Sort.by("menuPrice").descending());
        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();

        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
    }

    public void registMenu(MenuDTO menuDTO) {
        Menu menu = modelMapper.map(menuDTO, Menu.class);
        System.out.println(menu);
        menuRepository.save(menu);
    }

    @Transactional
    public void modifyMenu(MenuDTO menuDTO) {
        Menu menu = menuRepository.findById(menuDTO.getMenuCode()).orElseThrow(IllegalAccessError::new);
        menu.modifyMenuName(menuDTO.getMenuName());
    }

    @Transactional
    public void deleteMenu(int menuCode) {
        menuRepository.deleteById(menuCode);
    }
}
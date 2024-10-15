package com.ohgiraffers.chap06.menu.controller;

import com.ohgiraffers.chap06.common.Pagenation;
import com.ohgiraffers.chap06.common.PagingButton;
import com.ohgiraffers.chap06.menu.dto.CategoryDTO;
import com.ohgiraffers.chap06.menu.dto.MenuDTO;
import com.ohgiraffers.chap06.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @RequestMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable int menuCode, Model model) {
        MenuDTO menuDTO = menuService.findMenuByCode(menuCode);
        model.addAttribute("menu", menuDTO);
        return "menu/detail";
    }

    @GetMapping("/list")
    public String findMenuList(Model model, @PageableDefault Pageable pageable) {

        /* 페이징 처리 이전 단순 정렬 */
/*        List<MenuDTO> menuList = menuService.findMenuList();
        model.addAttribute("menuList", menuList); */

        /* 페이징 처리 포함 */
        log.info("pageable : {}", pageable);
        Page<MenuDTO> menuList = menuService.findMenuList(pageable);

        PagingButton paging = Pagenation.getPagingButtonInfo(menuList);

        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        return "menu/list";
    }

    @RequestMapping("/queryMethod")
    public void queryMethodPage() {}

    @RequestMapping("/search")
    public String findByMenuPrice(@RequestParam Integer menuPrice, Model model) {
        List<MenuDTO> menuList = menuService.findByMenuPrice(menuPrice);
        model.addAttribute("menuList", menuList);
        return "menu/searchResult";
    }

    @GetMapping("/regist")
    public void regist() {}

    @RequestMapping("/category")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        return menuService.findAllCategory();
    }

    @PostMapping("/regist")
    public String registMenu(@ModelAttribute MenuDTO menuDTO) {
        menuService.registMenu(menuDTO);

        return "redirect:/menu/list";
    }

    @GetMapping("/modify")
    public void modify() {}

    @PostMapping("/modify")
    public String modifyMenu(@ModelAttribute MenuDTO menuDTO) {
        menuService.modifyMenu(menuDTO);

        return "redirect:/menu/" + menuDTO.getMenuCode();
    }

    @GetMapping("/delete")
    public void delete() {}

    @PostMapping("/delete")
    public String deleteMenu(@RequestParam int menuCode) {
        menuService.deleteMenu(menuCode);

        return "redirect:/menu/list";
    }
}

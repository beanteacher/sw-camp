package com.ohgiraffers.section02.javaconfig;

import java.util.List;

public class MenuController {

    private final MenuService menuService;
    private final PrintResult printResult;

    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }

    public void selectAllMenu() {
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null && !menuList.isEmpty()) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByMenuCode(int menuCode) {

        MenuDTO menuDTO = menuService.selectMenuByMenuCode(menuCode);

        if (menuDTO != null) {
            printResult.printMenu(menuDTO);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registMenu(MenuDTO menuDTO) {
        int count = menuService.registMenu(menuDTO);

        if(count > 0) {
            printResult.printSuccessMessage("insert");
        } else{
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyMenu(MenuDTO menuDTO) {
        int count = menuService.modifyMenu(menuDTO);

        if(count > 0) {
            printResult.printSuccessMessage("update");
        } else{
            printResult.printErrorMessage("update");
        }
    }

    public void deleteMenu(int menuCode) {
        int count = menuService.deleteMenu(menuCode);

        if(count > 0) {
            printResult.printSuccessMessage("delete");
        } else{
            printResult.printErrorMessage("delete");
        }
    }
}

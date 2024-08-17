package com.java_outletdelivery.service;

import com.java_outletdelivery.dto.MenuDto;

import java.util.List;

public interface MenuService {
    List<MenuDto> findAllMenus();
    MenuDto findMenuById(Long menuId);
    void updateMenu(MenuDto menuDto);
    void deleteMenu(Long menuId);
    MenuDto findMenuByStock(Long menuStock);
    List<MenuDto> searchMenus(String query);
    void createMenu(MenuDto menuDto);
}

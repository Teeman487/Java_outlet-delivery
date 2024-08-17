package com.java_outletdelivery.service.impl;

import com.java_outletdelivery.dto.MenuDto;
import com.java_outletdelivery.entity.Menu;
import com.java_outletdelivery.mapper.MenuMapper;
import com.java_outletdelivery.repository.MenuRepository;
import com.java_outletdelivery.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    private MenuRepository menuRepository;


    @Override
    public void createMenu(MenuDto menuDto) {
          Menu menu = MenuMapper.mapToMenu(menuDto);
          menuRepository.save(menu);
    }

    @Override
    public void updateMenu(MenuDto menuDto) {
        Menu menu = MenuMapper.mapToMenu(menuDto);
        menuRepository.save(menu);
    }


    @Override
    public List<MenuDto> findAllMenus() {
        List<Menu>menus=menuRepository.findAll();
        return menus.stream().map(MenuMapper::mapToMenuDto)
                .collect(Collectors.toList());
    }

    @Override
    public MenuDto findMenuById(Long menuId) {
        Menu menu = menuRepository.findById(menuId).get();
        return MenuMapper.mapToMenuDto(menu);
    }


    @Override
    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }

    @Override
    public MenuDto findMenuByStock(Long menuStock) {
        Menu menu = menuRepository.findByStock(menuStock).get();
        return MenuMapper.mapToMenuDto(menu);
    }

    @Override
    public List<MenuDto> searchMenus(String query) {
        List<Menu> menus = menuRepository.searchMenus(query);
        return menus.stream()
                .map(MenuMapper::mapToMenuDto).
                collect(Collectors.toList());
    }
}

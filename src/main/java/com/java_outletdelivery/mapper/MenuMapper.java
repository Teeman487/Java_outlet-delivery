package com.java_outletdelivery.mapper;

import com.java_outletdelivery.dto.MenuDto;
import com.java_outletdelivery.entity.Menu;

public class MenuMapper {
        // Entity to Dto
        public static MenuDto mapToMenuDto(Menu menu) {
            return MenuDto.builder()
                    .id(menu.getId())
                    .name(menu.getName())
                    .stock(menu.getStock())
                    .price(menu.getPrice())
                    .description(menu.getDescription())
                    .createdOn(menu.getCreatedOn())
                    .updateOn(menu.getUpdateOn())
                    .build();
        }

        // Dto to Entity
        public static Menu mapToMenu(MenuDto menuDto) {
            return Menu.builder()
                    .id(menuDto.getId())
                    .name(menuDto.getName())
                    .stock(menuDto.getStock())
                    .price(menuDto.getPrice())
                    .description(menuDto.getDescription())
                    .createdOn(menuDto.getCreatedOn())
                    .updateOn(menuDto.getUpdateOn())
                    .build();
        }
    }

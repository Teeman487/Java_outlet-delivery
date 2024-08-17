package com.java_outletdelivery.controller;

import com.java_outletdelivery.Component.MenuValidator;
import com.java_outletdelivery.dto.MenuDto;
import com.java_outletdelivery.service.MenuService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class MenuController {
    private MenuService menuService;
    private MenuValidator validation;

    // Handler method for all menus
    @GetMapping("/restaurant/menus")
    public String menus(Model model){
        List<MenuDto> menus =menuService.findAllMenus();
        model.addAttribute("menus",menus);
        return "client/menus";
    }

    // Handler method for new menu page
    @GetMapping("/restaurant/menus/new")
    public String newMenu(Model model){
        MenuDto menuDto = new MenuDto();
        model.addAttribute("menu",menuDto);
        return "client/create_menu";
    }

    // Handler method for submit new menu
    @PostMapping("restaurant/menu")
    public String createMenu(@ModelAttribute("menu") @Valid MenuDto menuDto,
                             BindingResult result,
                             Model model
    )
    {
        validation.validate(menuDto, result);

        if(result.hasErrors()) {
            model.addAttribute("menu", menuDto);
            return "client/create_menu";
        }


        menuService.createMenu(menuDto);
        return "redirect:/restaurant/menus";
    }

    // Handler method to handle menu request
    @GetMapping("/restaurant/menus/{menuId}/edit")
    public String editMenuForm(@PathVariable("menuId") Long menuId, Model model){

        MenuDto menuDto = menuService.findMenuById(menuId);
        model.addAttribute("menu", menuDto);
        return "client/edit_menu";
    }

    // Handler method to handle edit menu form submit request
    @PostMapping("/restaurant/menus/{menuId}")
    public  String  updateMenu(@PathVariable("menuId") Long menuId,
                               @Valid @ModelAttribute("menu") MenuDto menuDto,
                               BindingResult result,
                               Model model) {
        if(result.hasErrors()){
            model.addAttribute("menu",menuDto);
            return  "client/edit_menu";
        }
        menuDto.setId(menuId);
        menuService.updateMenu(menuDto);
        return "redirect:/restaurant/menus";
    }

    // Handler method to handle view menu request
    @GetMapping("/restaurant/menus/{menuStock}/view")
    public String viewMenu(@PathVariable("menuStock") Long menuStock,
                           Model model) {
        MenuDto menuDto = menuService.findMenuByStock(menuStock);
        model.addAttribute("menu", menuDto);
        return "client/view_menu";
    }

    // Handler method to handle delete menu request
    @GetMapping("/restaurant/menus/{menuId}/delete")
    public String deleteMenu(@PathVariable("menuId") Long menuId){
        menuService.deleteMenu(menuId);
        return "redirect:/restaurant/menus";

    }

    // Handler method to handle search menus request
    @GetMapping("/restaurant/menus/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model){
        List<MenuDto> menus = menuService.searchMenus(query);
        model.addAttribute("menus", menus);
        return "client/menus";


    }
}

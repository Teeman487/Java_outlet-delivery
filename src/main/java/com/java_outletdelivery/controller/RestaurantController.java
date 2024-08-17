package com.java_outletdelivery.controller;

import com.java_outletdelivery.dto.RestaurantDto;
import com.java_outletdelivery.entity.Restaurant;
import com.java_outletdelivery.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RestaurantController {
     private RestaurantService restaurantService;



    // Handler method to handle a new Restaurant Interface
    @GetMapping("/restaurant")
    public String newRestaurant(Model model) {

        RestaurantDto restaurantDto = new RestaurantDto();

        model.addAttribute("restaurantDto", restaurantDto);   ///
        return "client/create_restaurant";
    }

    // Handler method to submit Restaurant Info
    @PostMapping("/restaurant/error")
    public String submitRestaurant(@Valid @ModelAttribute("restaurantDto")  RestaurantDto restaurantDto,
                             BindingResult result,
                             Model model){
        Restaurant restaurantByEmail= restaurantService.findRestaurantByEmail(restaurantDto.getEmail());

   if(restaurantByEmail != null && restaurantByEmail.getEmail() !=null && !restaurantByEmail.getEmail().isEmpty())
            result.rejectValue("email", null, "There is already a restaurant with same email id");

        if(result.hasErrors()){
            model.addAttribute("restaurantDto", restaurantDto);
            return "client/create_restaurant";
        }
        restaurantService.createRestaurant(restaurantDto);
        return "redirect:/restaurant?success";
    }
}

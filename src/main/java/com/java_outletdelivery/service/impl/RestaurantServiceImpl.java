package com.java_outletdelivery.service.impl;

import com.java_outletdelivery.dto.RestaurantDto;
import com.java_outletdelivery.entity.Restaurant;
import com.java_outletdelivery.repository.RestaurantRepository;
import com.java_outletdelivery.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;

    // Simply create restaurant for login
    @Override
    public void createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setTypeOfEstablishment(restaurantDto.getTypeOfEstablishment());
        restaurant.setEmail(restaurantDto.getEmail());
        restaurant.setPhone(restaurantDto.getPhone());
        restaurant.setPassword(restaurantDto.getPassword());
        restaurantRepository.save(restaurant);
    }


     @Override
    public Restaurant findRestaurantByEmail(String restaurantEmail) {
       return restaurantRepository.findByEmail(restaurantEmail);
    }


}

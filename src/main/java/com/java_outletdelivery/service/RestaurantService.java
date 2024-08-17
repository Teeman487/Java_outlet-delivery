package com.java_outletdelivery.service;

import com.java_outletdelivery.dto.RestaurantDto;
import com.java_outletdelivery.entity.Restaurant;

public interface RestaurantService {

    Restaurant findRestaurantByEmail(String email);
    void createRestaurant(RestaurantDto restaurantDto);



}

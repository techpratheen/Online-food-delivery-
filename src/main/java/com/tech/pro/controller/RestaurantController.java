package com.tech.pro.controller;

import com.tech.pro.entity.Restaurant;
import com.tech.pro.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable("id") Long id){
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(id);
        return restaurant.orElse(null);
    }

    @PostMapping("/restaurant")
    public Restaurant addOrUpdateRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addOrUpdateRestaurant(restaurant);
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id){
        restaurantService.deleteRestaurant(id);
    }

    @GetMapping("/restaurant/name")
    public Restaurant searchRestaurant(@RequestParam("name") String name){
        return restaurantService.searchRestaurant(name);
    }
}

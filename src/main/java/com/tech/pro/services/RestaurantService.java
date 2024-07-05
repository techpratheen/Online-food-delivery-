package com.tech.pro.services;

import com.tech.pro.entity.Restaurant;
import com.tech.pro.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    
    public Restaurant addOrUpdateRestaurant(Restaurant restaurant) {
        restaurant.getRestaurantContacts().forEach(restaurantContact -> restaurantContact.setRestaurant(restaurant));
        restaurant.getRestaurantAddress().forEach(restaurantAddress -> restaurantAddress.setRestaurant(restaurant));
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant searchRestaurant(String name) {
        return restaurantRepository.findByname(name);
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }
}

package com.RestaurantMenu.service;

import com.RestaurantMenu.entities.Restaurant;
import java.util.List;
import java.util.Optional;

public interface IRestaurantService {

    List<Restaurant> listRestaurant();

    void save(Restaurant restaurant);

    Optional<Restaurant> findById(Long id);

    void delete(Long id);

}

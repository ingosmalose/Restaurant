package com.RestaurantMenu.persistance;

import com.RestaurantMenu.entities.Restaurant;
import java.util.List;
import java.util.Optional;

public interface IRestaurantDAO {
    
    List<Restaurant> listRestaurant();
    
    Optional<Restaurant> findById(Long id);
    
    void save(Restaurant restaurant);
    
    void delete(Long id);
    
}

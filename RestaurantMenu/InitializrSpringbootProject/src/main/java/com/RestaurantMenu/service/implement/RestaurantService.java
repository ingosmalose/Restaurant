package com.RestaurantMenu.service.implement;

import com.RestaurantMenu.entities.Restaurant;
import com.RestaurantMenu.persistance.IRestaurantDAO;
import com.RestaurantMenu.service.IRestaurantService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService implements IRestaurantService{

    @Autowired
    private IRestaurantDAO persistance;
    
    @Override
    public List<Restaurant> listRestaurant() {
        //return (List<Restaurant>) persistance.listRestaurant();
        return persistance.listRestaurant();
    }

    @Override
    public void save(Restaurant restaurant) {
        persistance.save(restaurant);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return persistance.findById(id);
    }

    @Override
    public void delete(Long id) {
        persistance.delete(id);
    }
    
}

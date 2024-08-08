package com.RestaurantMenu.persistance.implement;

import com.RestaurantMenu.entities.Restaurant;
import com.RestaurantMenu.persistance.IRestaurantDAO;
import com.RestaurantMenu.repository.RestaurantRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantImpDAO implements IRestaurantDAO{

    @Autowired
    private RestaurantRepository repository;
    
    @Override
    public List<Restaurant> listRestaurant() {
        return (List<Restaurant>) repository.findAll();
    }

    @Override
    public void save(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}

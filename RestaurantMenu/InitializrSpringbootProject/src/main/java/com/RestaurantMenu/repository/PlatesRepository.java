package com.RestaurantMenu.repository;

import com.RestaurantMenu.entities.Plate;
import org.springframework.data.repository.CrudRepository;

public interface PlatesRepository extends CrudRepository<Plate, Long> {
    
}

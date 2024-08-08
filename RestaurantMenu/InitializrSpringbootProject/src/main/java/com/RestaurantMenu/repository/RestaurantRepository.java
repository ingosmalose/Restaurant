package com.RestaurantMenu.repository;

import com.RestaurantMenu.entities.Restaurant;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
    
}

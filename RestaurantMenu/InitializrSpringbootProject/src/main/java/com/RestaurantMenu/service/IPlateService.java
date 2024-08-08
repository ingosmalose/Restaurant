package com.RestaurantMenu.service;

import com.RestaurantMenu.entities.Plate;
import java.util.List;
import java.util.Optional;

public interface IPlateService {
    
    Optional<Plate> findById(Long id);
    
    List<Plate> listAll();
    
    void save(Plate plate);
    
    void delete(Long id);
}

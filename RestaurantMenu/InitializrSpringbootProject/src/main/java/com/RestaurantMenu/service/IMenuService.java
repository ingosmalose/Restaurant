package com.RestaurantMenu.service;

import com.RestaurantMenu.entities.Menu;
import java.util.List;
import java.util.Optional;


public interface IMenuService {
    
    
    List<Menu> ListMenu();
    
    void save(Menu menu);
    
    Optional<Menu> FindById(Long id);
    
    void delete(Long Id);
}
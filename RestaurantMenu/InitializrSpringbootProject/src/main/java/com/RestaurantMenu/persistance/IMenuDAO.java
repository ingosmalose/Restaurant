package com.RestaurantMenu.persistance;

import com.RestaurantMenu.entities.Menu;
import java.util.List;
import java.util.Optional;

public interface IMenuDAO {
    
    List<Menu> ListMenu();
    
    void save(Menu menu);
    
    Optional<Menu> FindById(Long id);
    
    void delete(Long Id);
}

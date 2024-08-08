package com.RestaurantMenu.persistance.implement;

import com.RestaurantMenu.entities.Menu;
import com.RestaurantMenu.entities.Restaurant;
import com.RestaurantMenu.persistance.IMenuDAO;
import com.RestaurantMenu.persistance.IRestaurantDAO;
import com.RestaurantMenu.repository.MenuRespository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuDAO implements IMenuDAO {

    @Autowired
    MenuRespository repository;

    @Override
    public List<Menu> ListMenu() {
        return(List<Menu>) repository.findAll();
    }

    @Override
    public void save(Menu menu) {
        repository.save(menu);
    }

    @Override
    public Optional<Menu> FindById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long Id) {
        repository.deleteById(Id);
    }

    
}

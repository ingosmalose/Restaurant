package com.RestaurantMenu.service.implement;

import com.RestaurantMenu.entities.Menu;
import com.RestaurantMenu.persistance.IMenuDAO;
import com.RestaurantMenu.service.IMenuService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService implements IMenuService {

    @Autowired
    IMenuDAO persistance;
    
    @Override
    public List<Menu> ListMenu() {
        return persistance.ListMenu();
    }

    @Override
    public void save(Menu menu) {
        persistance.save(menu);
    }

    @Override
    public Optional<Menu> FindById(Long id) {
        return persistance.FindById(id);
    }

    @Override
    public void delete(Long Id) {
        persistance.delete(Id);
    }
    
}

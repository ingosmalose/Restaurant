package com.RestaurantMenu.service.implement;

import com.RestaurantMenu.entities.Plate;
import com.RestaurantMenu.persistance.IPlateDAO;
import com.RestaurantMenu.service.IPlateService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateService implements IPlateService{
    
    @Autowired
    IPlateDAO persistance;
    
    @Override
    public Optional<Plate> findById(Long id) {
        return persistance.findById(id);
    }

    @Override
    public List<Plate> listAll() {
        return persistance.listAll();
    }

    @Override
    public void save(Plate plate) {
        persistance.save(plate);
    }

    @Override
    public void delete(Long id) {
        persistance.delete(id);
    }
    
}

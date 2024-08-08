package com.RestaurantMenu.persistance.implement;

import com.RestaurantMenu.entities.Plate;
import com.RestaurantMenu.persistance.IPlateDAO;
import com.RestaurantMenu.repository.PlatesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlateDAO implements IPlateDAO {
    
    @Autowired
    PlatesRepository repository;
    
    @Override
    public Optional<Plate> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Plate> listAll() {
        return (List<Plate>) repository.findAll();
    }

    @Override
    public void save(Plate plate) {
        repository.save(plate);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}

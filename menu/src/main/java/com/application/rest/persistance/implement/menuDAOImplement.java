package com.application.rest.persistance.implement;

import com.application.rest.entities.tbl_menu;
import com.application.rest.persistance.IMenuDAO;
import com.application.rest.repository.menuRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class menuDAOImplement implements IMenuDAO{
    @Autowired
    public menuRepository menuRepository;
    
    @Override
    public List<tbl_menu> listAll() {
        return (List<tbl_menu>) menuRepository.findAll();
    }

    @Override
    public Optional<tbl_menu> findById(Long id) {
        return (Optional<tbl_menu>) menuRepository.findById(id);
    }

    @Override
    public void save(tbl_menu info) {
        menuRepository.save(info);
    }

    @Override
    public void deleteById(Long Id) {
        menuRepository.deleteById(Id);
    }

    @Override
    public void updateById(tbl_menu info) {
        menuRepository.save(info);
    }
    
}

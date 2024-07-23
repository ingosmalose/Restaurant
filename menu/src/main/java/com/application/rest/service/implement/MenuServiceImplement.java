package com.application.rest.service.implement;

import com.application.rest.entities.tbl_menu;
import com.application.rest.persistance.IMenuDAO;
import com.application.rest.service.IMenuService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImplement implements IMenuService{
    
    @Autowired
    private IMenuDAO menu;

    @Override
    public List<tbl_menu> listAll() {
        return menu.listAll();
    }

    @Override
    public void save(tbl_menu info) {
        menu.save(info);
    }

    @Override
    public void deleteById(Long Id) {
        menu.deleteById(Id);
    }

    @Override
    public void updateById(tbl_menu info) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<tbl_menu> findById(Long Id) {
        return (Optional<tbl_menu>) menu.findById(Id);
    }
    
}

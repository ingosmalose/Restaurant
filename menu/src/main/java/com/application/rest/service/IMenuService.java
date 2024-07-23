package com.application.rest.service;

import com.application.rest.entities.tbl_menu;
import java.util.List;
import java.util.Optional;

public interface IMenuService {
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: List all menus
    */
    List<tbl_menu> listAll();
    
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: Create a new menu
    */
    void save(tbl_menu info);
    
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: Delete a selected menu
    */
    void deleteById(Long Id);
    
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: Updated a selected menu
    */
    void updateById(tbl_menu info);
    
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: Get a specific menu
    */
    Optional<tbl_menu> findById(Long Id);
}

package com.application.rest.service;

import com.application.rest.entity.Reservation;
import java.util.List;

public interface IReservationService {
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: List all reservation saving on data base
    */
    List<Reservation> listAll();
            
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: List all reservation in a day selected
    */
    List<Reservation> listAllByDate(String date);
    
    //  *****************
    //  ACTIONS
    
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: Create a new reservation
    */
    void save(Reservation info);
    
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: Create a new reservation
    */
    void deleteById(Long Id);
    
    /*
    Created by: Oscar Lopez
    Date: Jul 23 / 2024
    Detail: Create a new reservation
    */
    void updateById(Reservation info);
}

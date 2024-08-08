package com.RestaurantMenu.service;

import com.RestaurantMenu.entities.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    
    List<Reservation> listReservation();
    
    Optional<Reservation> findById(Long id);
    
    List<Reservation> listDate(String begin, String ending);
    
    Long limitReservation(String date, String time);
    
    void save(Reservation reservation);
    
    void delete(Long id);
    
}

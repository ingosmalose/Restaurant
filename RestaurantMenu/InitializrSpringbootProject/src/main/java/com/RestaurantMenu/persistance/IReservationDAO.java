package com.RestaurantMenu.persistance;

import com.RestaurantMenu.entities.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationDAO {
    
    List<Reservation> listAll();
    
    Optional<Reservation> find(Long id);
    
    List<Reservation> listDate(String begin, String ending);
    
    Long limitReservation(String date, String time);
    
    void save(Reservation reservation);
    
    void delete(Long id);
    
}

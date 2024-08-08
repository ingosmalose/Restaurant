package com.RestaurantMenu.service.implement;

import com.RestaurantMenu.entities.Reservation;
import com.RestaurantMenu.persistance.IReservationDAO;
import com.RestaurantMenu.service.IReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService{
    
    @Autowired
    IReservationDAO persistance;

    @Override
    public List<Reservation> listReservation() {
        return persistance.listAll();
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return persistance.find(id);
    }

    @Override
    public void save(Reservation reservation) {
        persistance.save(reservation);
    }

    @Override
    public void delete(Long id) {
        persistance.delete(id);
    }
    
    @Override
    public List<Reservation> listDate(String begin, String ending) {
        return persistance.listDate(begin, ending);
    }

    @Override
    public Long limitReservation(String date, String time) {
        return persistance.limitReservation(date, time);
    }

}

package com.RestaurantMenu.persistance.implement;

import com.RestaurantMenu.entities.Reservation;
import com.RestaurantMenu.persistance.IReservationDAO;
import com.RestaurantMenu.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationDAO implements IReservationDAO{
    
    @Autowired
    ReservationRepository repository;
    
    @Override
    public List<Reservation> listAll() {
        return (List<Reservation>) repository.findAll();
    }

    @Override
    public Optional<Reservation> find(Long id) {
        return (Optional<Reservation>) repository.findById(id);
    }

    @Override
    public void save(Reservation reservation) {
        repository.save(reservation);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    //*
    @Override
    public List<Reservation> listDate(String begin, String ending) {
        return (List<Reservation>) repository.findAppointmentDateRange(begin, ending);
    }// */

    @Override
    public Long limitReservation(String date, String time) {
        return repository.limitReservation(date, time);
    }
    
}

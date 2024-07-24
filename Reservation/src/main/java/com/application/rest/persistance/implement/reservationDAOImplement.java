package com.application.rest.persistance.implement;

import com.application.rest.entity.Reservation;
import com.application.rest.persistance.IReservationDAO;
import com.application.rest.repository.reservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class reservationDAOImplement implements IReservationDAO  {
    @Autowired
    private reservationRepository reservationRespository;
    
    @Override
    public List<Reservation> listAll() {
        return (List<Reservation>) reservationRespository.findAll();
    }

    @Override
    public List<Reservation> listAllByDate(String date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void save(Reservation info) {
        reservationRespository.save(info);
    }

    @Override
    public void deleteById(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateById(Reservation info) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

package com.application.rest.service.implement;

import com.application.rest.entity.Reservation;
import com.application.rest.persistance.IReservationDAO;
import com.application.rest.service.IReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reservationServiceImplement implements IReservationService {

    @Autowired
    private IReservationDAO reservationDao;
    
    @Override
    public List<Reservation> listAll() {
        return reservationDao.listAll();
    }

    @Override
    public List<Reservation> listAllByDate(String date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Reservation info) {
        reservationDao.save(info);
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
